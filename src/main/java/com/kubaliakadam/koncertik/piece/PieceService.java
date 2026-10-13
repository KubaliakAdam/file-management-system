package com.kubaliakadam.koncertik.piece;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;
import java.util.UUID;

@Service
public class PieceService {

    private final PieceRepository repository;

    public PieceService(PieceRepository repository) {
        this.repository = repository;
    }

    public List<Piece> findAll() {
        return repository.findByDeletedFalseOrderByTitleAsc();
    }

    public Piece findById(UUID id) {
        return repository.findById(id)
                .filter(piece -> !piece.isDeleted())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Piece not found"));
    }

    public Piece create(PieceRequest request) {
        UUID id = request.id() != null ? request.id() : UUID.randomUUID();
        return repository.save(new Piece(id, request.title(), request.composer()));
    }

    public Piece update(UUID id, PieceRequest request) {
        Piece piece = findById(id);
        piece.setTitle(request.title());
        piece.setComposer(request.composer());
        return repository.save(piece);
    }

    public void delete(UUID id) {
        Piece piece = findById(id);
        piece.setDeleted(true);
        repository.save(piece);
    }
}
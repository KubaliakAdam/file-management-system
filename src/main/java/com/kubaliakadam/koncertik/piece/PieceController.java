package com.kubaliakadam.koncertik.piece;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/pieces")
public class PieceController {

    private final PieceService service;

    public PieceController(PieceService service) {
        this.service = service;
    }

    @GetMapping
    public List<PieceResponse> list() {
        return service.findAll().stream().map(PieceResponse::from).toList();
    }

    @GetMapping("/{id}")
    public PieceResponse get(@PathVariable UUID id) {
        return PieceResponse.from(service.findById(id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PieceResponse create(@Valid @RequestBody PieceRequest request) {
        return PieceResponse.from(service.create(request));
    }

    @PutMapping("/{id}")
    public PieceResponse update(@PathVariable UUID id, @Valid @RequestBody PieceRequest request) {
        return PieceResponse.from(service.update(id, request));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable UUID id) {
        service.delete(id);
    }
}
package com.kubaliakadam.koncertik.piece;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.UUID;

public interface PieceRepository extends JpaRepository<Piece, UUID> {

    List<Piece> findByDeletedFalseOrderByTitleAsc();
}
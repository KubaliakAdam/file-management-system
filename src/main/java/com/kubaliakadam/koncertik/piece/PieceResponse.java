package com.kubaliakadam.koncertik.piece;

import java.time.Instant;
import java.util.UUID;

public record PieceResponse(UUID id, String title, String composer, Instant updatedAt) {

    static PieceResponse from(Piece piece) {
        return new PieceResponse(
                piece.getId(), piece.getTitle(), piece.getComposer(), piece.getUpdatedAt());
    }
}
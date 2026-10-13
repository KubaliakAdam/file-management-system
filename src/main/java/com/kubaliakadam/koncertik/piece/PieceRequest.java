package com.kubaliakadam.koncertik.piece;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import java.util.UUID;

public record PieceRequest(
        UUID id,
        @NotBlank @Size(max = 255) String title,
        @Size(max = 255) String composer
) {}
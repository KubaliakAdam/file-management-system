package com.kubaliakadam.koncertik.piece;

import jakarta.persistence.*;
import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "pieces")
public class Piece {

    @Id
    private UUID id;

    @Column(nullable = false)
    private String title;

    private String composer;

    @Column(nullable = false)
    private Instant updatedAt;

    @Column(nullable = false)
    private boolean deleted = false;

    protected Piece() {
        // required by JPA
    }

    public Piece(UUID id, String title, String composer) {
        this.id = id;
        this.title = title;
        this.composer = composer;
    }

    @PrePersist
    @PreUpdate
    void touch() {
        updatedAt = Instant.now();
    }

    public UUID getId() { return id; }
    public String getTitle() { return title; }
    public String getComposer() { return composer; }
    public Instant getUpdatedAt() { return updatedAt; }
    public boolean isDeleted() { return deleted; }

    public void setTitle(String title) { this.title = title; }
    public void setComposer(String composer) { this.composer = composer; }
    public void setDeleted(boolean deleted) { this.deleted = deleted; }
}
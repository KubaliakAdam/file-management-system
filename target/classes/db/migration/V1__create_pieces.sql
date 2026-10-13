CREATE TABLE pieces (
    id UUID PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    composer VARCHAR(255),
    updated_at TIMESTAMPTZ NOT NULL,
    deleted BOOLEAN NOT NULL DEFAULT false
);
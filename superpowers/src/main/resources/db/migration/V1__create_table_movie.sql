CREATE TABLE superpower
(
    id                BIGINT,
    nome              VARCHAR(255),
    descricao         VARCHAR(255),
    nivel_inutilidade INTEGER NOT NULL,
    CONSTRAINT pk_superpower PRIMARY KEY (id)
);
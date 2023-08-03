CREATE TABLE filmes (
    id BIGSERIAL NOT NULL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    duracao INT NOT NULL,
    lancamento INT NOT NULL,
    genero VARCHAR(100)
);

CREATE TABLE alunos(
    id bigint NOT NULL auto_increment,
    nome VARCHAR(200) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    telefone VARCHAR(20) NOT NULL,
    status TINYINT NOT NULL,
    PRIMARY KEY(id)
);
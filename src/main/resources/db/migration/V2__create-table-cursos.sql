CREATE TABLE cursos(
    id bigint NOT NULL auto_increment,
    curso VARCHAR(200) NOT NULL,
    descricao TEXT NOT NULL,
    status TINYINT NOT NULL,
    PRIMARY KEY(id)
);
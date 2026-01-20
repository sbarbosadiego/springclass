CREATE TABLE matriculas (
    id BIGINT NOT NULL AUTO_INCREMENT,
    aluno_id BIGINT NOT NULL,
    curso_id BIGINT NOT NULL,
    data_matricula TIMESTAMP NOT NULL,
    status BOOLEAN NOT NULL,

    CONSTRAINT pk_matriculas PRIMARY KEY (id),

    CONSTRAINT fk_matriculas_aluno
        FOREIGN KEY (aluno_id)
        REFERENCES alunos(id),

    CONSTRAINT fk_matriculas_curso
        FOREIGN KEY (curso_id)
        REFERENCES cursos(id)
);

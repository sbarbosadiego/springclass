package br.com.springclass.springclass.model.entities;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Length;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Aluno {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pk_codigo_aluno")
	private Long codigoAluno;

	@NotBlank
	@Length(max = 200)
	@Column(name = "nome_aluno", length = 200, nullable = false)
	private String nomeAluno;

	@CreationTimestamp
	@Column(name = "data_cadastro")
	private LocalDateTime dataCriacao;

	public Aluno() {

	}

	public Aluno(@NotBlank @Length(max = 200) String nomeAluno, LocalDateTime dataCriacao) {
		super();
		this.nomeAluno = nomeAluno;
		this.dataCriacao = dataCriacao;
	}

	public String getNomeAluno() {
		return nomeAluno;
	}

	public void setNomeAluno(String nomeAluno) {
		this.nomeAluno = nomeAluno;
	}

	public LocalDateTime getDataCriacao() {
		return dataCriacao;
	}

	public Long getCodigoAluno() {
		return codigoAluno;
	}

	public void setCodigoAluno(Long codigoAluno) {
		this.codigoAluno = codigoAluno;
	}

	public void setDataCriacao(LocalDateTime dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

}

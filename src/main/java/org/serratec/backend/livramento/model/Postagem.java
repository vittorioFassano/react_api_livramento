package org.serratec.backend.livramento.model;

import java.time.LocalDate;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "postagem")
public class Postagem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Schema(description = "Identificador unico de post")
	private Long id;

	@NotBlank(message = "Preencha o título")
	@Size(max = 100)
	@Column(nullable = false, length = 100)
	@Schema(description = "Título do livro")
	private String titulo;

	@NotBlank(message = "Preencha a descrição")
	@Size(max = 500)
	@Column(nullable = false, length = 500)
	@Schema(description = "Descrição do livro")
	private String descricao;

	@NotBlank(message = "Preencha a nota do livro")
	@Min(value = 0, message = "A nota do livro deve ser no mínimo 0")
	@Max(value = 10, message = "A nota do livro deve estar entre 0 e 10")
	@Schema(description = "Nota do livro")
	private String nota;

	@NotBlank(message = "Preencha o usuário do post")
	@Size(max = 100)
	@Column(nullable = false, length = 30)
	@Schema(description = "Usuário do post")
	private String usuario;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "foto_id", referencedColumnName = "id_foto")
	private Foto foto;

	@Column(name = "data_criacao")
	private LocalDate dataCriacao;

	@PrePersist
	protected void onCreate() {
		this.dataCriacao = LocalDate.now();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getNota() {
		return nota;
	}

	public void setNota(String nota) {
		this.nota = nota;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public LocalDate getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(LocalDate dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public Foto getFoto() {
		return foto;
	}

	public void setFoto(Foto foto) {
		this.foto = foto;
	}

}

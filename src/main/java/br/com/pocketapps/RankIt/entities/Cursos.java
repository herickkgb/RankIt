package br.com.pocketapps.RankIt.entities;

import br.com.pocketapps.RankIt.entities.enums.CategoriaEnum;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "tb_cursos")
public class Cursos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String author;
    private Double nota;
    private Integer numeroDeAulas;
    private Integer duracaoTotalCurso;
    private String preco;
    private String descricao;

    @ManyToMany
    @JoinTable(
            name = "tb_cursos_categorias",
            joinColumns = @JoinColumn(name = "curso_id"),
            inverseJoinColumns = @JoinColumn(name = "categoria_id")
    )
    @JsonBackReference
    private Set<Categoria> categorias = new HashSet<>();

    public Cursos() {
    }


    public Cursos(Long id, String nome, String author, Double nota, Integer numeroDeAulas, Integer duracaoTotalCurso, String preco, String descricao) {
        this.id = id;
        this.nome = nome;
        this.author = author;
        this.nota = nota;
        this.numeroDeAulas = numeroDeAulas;
        this.duracaoTotalCurso = duracaoTotalCurso;
        this.preco = preco;
        this.descricao = descricao;
    }

    // Getters e Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Double getNota() {
        return nota;
    }

    public void setNota(Double nota) {
        this.nota = nota;
    }

    public Integer getNumeroDeAulas() {
        return numeroDeAulas;
    }

    public void setNumeroDeAulas(Integer numeroDeAulas) {
        this.numeroDeAulas = numeroDeAulas;
    }

    public Integer getDuracaoTotalCurso() {
        return duracaoTotalCurso;
    }

    public void setDuracaoTotalCurso(Integer duracaoTotalCurso) {
        this.duracaoTotalCurso = duracaoTotalCurso;
    }

    public String getPreco() {
        return preco;
    }

    public void setPreco(String preco) {
        this.preco = preco;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Set<Categoria> getCategorias() {
        return categorias;
    }

    public void setCategorias(Set<Categoria> categorias) {
        this.categorias = categorias;
    }

    public void addCategoria(Categoria categoria, CategoriaEnum categoriaEnum) {
        if (categoria.isValidCategoriaEnum(categoriaEnum)) {
            this.categorias.add(categoria);
            categoria.getCursos().add(this);
        } else {
            throw new IllegalArgumentException("Categoria inválida.");
        }
    }

    public void removeCategoria(Categoria categoria) {
        this.categorias.remove(categoria);
        categoria.getCursos().remove(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cursos)) return false;
        Cursos cursos = (Cursos) o;
        return Objects.equals(getId(), cursos.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}

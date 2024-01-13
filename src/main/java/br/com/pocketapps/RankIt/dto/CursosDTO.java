package br.com.pocketapps.RankIt.dto;

import br.com.pocketapps.RankIt.entities.Categoria;
import br.com.pocketapps.RankIt.entities.Cursos;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class CursosDTO {
    private Long id;
    private String nome;
    private String author;
    private Double nota;
    private Integer numeroDeAulas;
    private Integer duracaoTotalCurso;
    private String preco;
    private String descricao;

    private Set<CategoriaDTO> categorias = new HashSet<>();

    public CursosDTO() {
    }

    public CursosDTO(Long id, String nome, String author, Double nota, Integer numeroDeAulas, Integer duracaoTotalCurso, String prico, String descricao) {
        this.id = id;
        this.nome = nome;
        this.author = author;
        this.nota = nota;
        this.numeroDeAulas = numeroDeAulas;
        this.duracaoTotalCurso = duracaoTotalCurso;
        this.preco = prico;
        this.descricao = descricao;
    }

    public CursosDTO(Cursos x) {
        this.author = x.getAuthor();
        this.nome = x.getNome();
        this.nota = x.getNota();
        this.descricao = x.getDescricao();
        this.preco = x.getPreco();
        for (Categoria entityAux : x.getCategorias()) {
            categorias.add(new CategoriaDTO(entityAux));
        }
        this.duracaoTotalCurso = x.getDuracaoTotalCurso();
        this.numeroDeAulas = x.getNumeroDeAulas();
        this.id = x.getId();
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getAuthor() {
        return author;
    }

    public Double getNota() {
        return nota;
    }

    public Integer getNumeroDeAulas() {
        return numeroDeAulas;
    }

    public Integer getDuracaoTotalCurso() {
        return duracaoTotalCurso;
    }

    public String getPreco() {
        return preco;
    }

    public Set<CategoriaDTO> getCategorias() {
        return categorias;
    }

    public String getDescricao() {
        return descricao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CursosDTO cursosDTO)) return false;
        return Objects.equals(getId(), cursosDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}

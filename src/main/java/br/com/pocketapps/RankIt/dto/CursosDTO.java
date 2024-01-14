package br.com.pocketapps.RankIt.dto;

import br.com.pocketapps.RankIt.entities.Categoria;
import br.com.pocketapps.RankIt.entities.Cursos;
import jakarta.validation.constraints.*;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class CursosDTO {
    private Long id;
    @NotBlank(message = "Campo Requerido")
    @Size(min = 3, max = 255)
    private String nome;

    @NotBlank(message = "Campo Requerido")
    private String author;

    @NotNull(message = "Campo Requerido")
    @Min(value = 0, message = "A nota não pode ser menor que 0")
    @Max(value = 10, message = "A nota não pode ser maior que 10")
    private Double nota;

    @NotNull(message = "Campo Requerido")
    @Positive(message = "O número de aulas deve ser positivo")
    private Integer numeroDeAulas;

    @NotNull(message = "Campo Requerido")
    @Positive(message = "A duração total do curso deve ser positiva")
    private Integer duracaoTotalCurso;

    @NotBlank(message = "Campo Requerido")
    private String preco;

    @Size(max = 1000, message = "A descrição não pode exceder 1000 caracteres")
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

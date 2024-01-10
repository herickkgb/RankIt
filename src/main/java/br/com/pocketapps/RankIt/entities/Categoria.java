package br.com.pocketapps.RankIt.entities;

import br.com.pocketapps.RankIt.entities.enums.CategoriaEnum;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "tb_categorias")
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @ManyToMany(mappedBy = "categorias")
    @JsonBackReference
    private Set<Cursos> cursos = new HashSet<>();

    public Categoria() {
    }

    public Categoria(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

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

    public Set<Cursos> getCursos() {
        return cursos;
    }

    public void setCursos(Set<Cursos> cursos) {
        this.cursos = cursos;
    }

    public void addCurso(Cursos curso) {
        this.cursos.add(curso);
        curso.getCategorias().add(this);
    }

    public void removeCurso(Cursos curso) {
        this.cursos.remove(curso);
        curso.getCategorias().remove(this);
    }

    public boolean isValidCategoriaEnum(CategoriaEnum categoriaEnum) {
        return this.nome.equals(categoriaEnum.name());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Categoria)) return false;
        Categoria categoria = (Categoria) o;
        return Objects.equals(getId(), categoria.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}

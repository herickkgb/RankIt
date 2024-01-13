package br.com.pocketapps.RankIt.dto;

import br.com.pocketapps.RankIt.entities.Categoria;
import br.com.pocketapps.RankIt.entities.Cursos;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.ManyToMany;

import java.util.HashSet;
import java.util.Set;

public class CategoriaDTO {

    private Long id;

    private String nome;
    private Set<Cursos> cursos = new HashSet<>();

    public CategoriaDTO() {
    }

    public CategoriaDTO(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public CategoriaDTO(Categoria entityAux) {
        this.id = entityAux.getId();
        this.nome = entityAux.getNome();
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Set<Cursos> getCursos() {
        return cursos;
    }
}

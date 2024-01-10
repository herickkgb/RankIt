package br.com.pocketapps.RankIt.repositories;

import br.com.pocketapps.RankIt.entities.Cursos;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CursosRepository extends JpaRepository<Cursos, Long> {

}

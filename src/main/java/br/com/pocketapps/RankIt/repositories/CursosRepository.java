package br.com.pocketapps.RankIt.repositories;

import br.com.pocketapps.RankIt.entities.Cursos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CursosRepository extends JpaRepository<Cursos, Long> {

}

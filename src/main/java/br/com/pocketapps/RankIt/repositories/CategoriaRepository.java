package br.com.pocketapps.RankIt.repositories;

import br.com.pocketapps.RankIt.entities.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria,Long>{
}

package br.com.pocketapps.RankIt.servicies;


import br.com.pocketapps.RankIt.dto.CursosDTO;
import br.com.pocketapps.RankIt.entities.Cursos;
import br.com.pocketapps.RankIt.repositories.CursosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CursosService {

    @Autowired
    private CursosRepository repository;

    @Transactional(readOnly = true)
    public List<CursosDTO> findAll() {
        List<Cursos> cursosList = repository.findAll();
        return cursosList.stream().map(x -> new CursosDTO(x)).toList();
    }

    @Transactional(readOnly = true)
    public CursosDTO findById(Long id) {
        Optional<Cursos> cursoOptional = repository.findById(id);
        if (cursoOptional.isPresent()) {
            CursosDTO cursoDTO = new CursosDTO(cursoOptional.get());
            return cursoDTO;
        } else {
            throw new RuntimeException("Curso não encontrado para o ID: " + id);
        }
    }



}



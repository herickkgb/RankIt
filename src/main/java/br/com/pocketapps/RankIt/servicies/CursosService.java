package br.com.pocketapps.RankIt.servicies;

import br.com.pocketapps.RankIt.dto.CategoriaDTO;
import br.com.pocketapps.RankIt.dto.CursosDTO;
import br.com.pocketapps.RankIt.entities.Categoria;
import br.com.pocketapps.RankIt.entities.Cursos;
import br.com.pocketapps.RankIt.repositories.CategoriaRepository;
import br.com.pocketapps.RankIt.repositories.CursosRepository;
import br.com.pocketapps.RankIt.servicies.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CursosService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CursosService.class);
    private static final String CURSO_NAO_ENCONTRADO = "Curso não encontrado para o ID: ";

    private final CursosRepository cursosRepository;
    private final CategoriaRepository categoriaRepository;

    public CursosService(CursosRepository cursosRepository, CategoriaRepository categoriaRepository) {
        this.cursosRepository = cursosRepository;
        this.categoriaRepository = categoriaRepository;
    }

    @Transactional(readOnly = true)
    public List<CursosDTO> findAll() {
        return cursosRepository.findAll().stream()
                .map(CursosDTO::new)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public CursosDTO findById(Long id) {
        Cursos cursos = cursosRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException(CURSO_NAO_ENCONTRADO + id.toString()));
        return new CursosDTO(cursos);
    }

    @Transactional
    public CursosDTO create(CursosDTO dto) {
        Cursos entity = convertToEntity(dto);
        try {
            entity = cursosRepository.save(entity);
            LOGGER.info("Curso salvo com sucesso");
        } catch (Exception e) {
            LOGGER.error("Erro ao salvar o curso", e);
            throw e;
        }
        return new CursosDTO(entity);
    }

    @Transactional
    public void delete(Long id) {
        try {
            cursosRepository.deleteById(id);
        } catch (Exception e) {
            LOGGER.error("Erro ao deletar o curso com ID: " + id, e);
            throw e;
        }
    }

    @Transactional
    public CursosDTO update(CursosDTO dto, Long id) {
        Cursos entity = convertToEntity(dto);
        entity.setId(id);
        try {
            entity = cursosRepository.save(entity);
            LOGGER.info("Curso atualizado com sucesso");
        } catch (Exception e) {
            LOGGER.error("Erro ao atualizar o curso", e);
            throw e;
        }
        return new CursosDTO(entity);
    }

    private Cursos convertToEntity(CursosDTO dto) {
        Cursos entity = new Cursos();
        entity.setAuthor(dto.getAuthor());
        entity.setNome(dto.getNome());
        entity.setNota(dto.getNota());
        entity.setDuracaoTotalCurso(dto.getDuracaoTotalCurso());
        entity.setPreco(dto.getPreco());
        entity.setDescricao(dto.getDescricao());
        for (CategoriaDTO catDTO : dto.getCategorias()) {
            Categoria cat = categoriaRepository.getReferenceById(catDTO.getId());
            entity.getCategorias().add(cat);
        }
        return entity;
    }
}

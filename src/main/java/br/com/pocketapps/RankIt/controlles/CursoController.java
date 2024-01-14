package br.com.pocketapps.RankIt.controlles;

import br.com.pocketapps.RankIt.dto.CursosDTO;
import br.com.pocketapps.RankIt.servicies.CursosService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api-v1")
public class CursoController {

    @Autowired
    private CursosService service;

    @Operation(summary = "Recuperar todos os cursos", method = "GET")
    @GetMapping("/all")
    public ResponseEntity<List<CursosDTO>> findAll() {
        List<CursosDTO> dtos = service.findAll();
        return ResponseEntity.ok(dtos);
    }


    @Operation(summary = "Buscar cursos por nome", method = "GET")
    @GetMapping("/name/{name}")
    public ResponseEntity<List<CursosDTO>> findByName(@PathVariable String name) {
        List<CursosDTO> dtos = service.findAll();
        List<CursosDTO> dtosFilter;
        dtosFilter = dtos.stream()
                .filter(curso -> curso.getNome().toLowerCase().contains(name.toLowerCase()))
                .collect(Collectors.toList());
        if (!dtosFilter.isEmpty()) {
            return ResponseEntity.ok(dtosFilter);
        } else {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @Operation(summary = "Buscar curso por ID", method = "GET")
    @GetMapping("/findById/{id}")
    public ResponseEntity<CursosDTO> findById(@PathVariable Long id) {
        CursosDTO dto = service.findById(id);
        return ResponseEntity.ok(dto);
    }
    @Operation(summary = "Inserir um novo curso", method = "POST")
    @PostMapping("/create")
    public ResponseEntity<CursosDTO> create(@Valid @RequestBody CursosDTO dto) {
        dto = service.create(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @Operation(summary = "Recuperar cursos em ordem crescente de nota", method = "GET")
    @GetMapping("/topRating")
    public ResponseEntity<List<CursosDTO>> findTopRating() {
        List<CursosDTO> dtos = new ArrayList<>(service.findAll());
        Collections.sort(dtos, Comparator.comparing(CursosDTO::getNota).reversed());

        return ResponseEntity.ok(dtos);
    }

    @Operation(summary = "Excluir curso por ID", method = "DELETE")
    @DeleteMapping("/deleteByID/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Atualiza as Informações de um Curso com Base no ID", method = "PUT")
    @PutMapping("/update/{id}")
    public ResponseEntity<CursosDTO> update(@Valid @RequestBody CursosDTO dto, @PathVariable Long id) {
        dto = service.update(id, dto);
        return ResponseEntity.ok(dto);
    }


}

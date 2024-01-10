package br.com.pocketapps.RankIt.controlles;

import br.com.pocketapps.RankIt.dto.CursosDTO;
import br.com.pocketapps.RankIt.entities.Cursos;
import br.com.pocketapps.RankIt.servicies.CursosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/cursos")
public class CursoController {

    @Autowired
    private CursosService service;

    @GetMapping("/all")
    public ResponseEntity<List<CursosDTO>> findAll() {
        List<CursosDTO> dtos = service.findAll();
        return ResponseEntity.ok(dtos);
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<List<CursosDTO>> findByName(@PathVariable String name) {
        List<CursosDTO> dtos = service.findAll();
        List<CursosDTO> dtosFilter = new ArrayList<>();
        dtosFilter = dtos.stream()
                .filter(curso -> curso.getNome().toLowerCase().contains(name.toLowerCase()))
                .collect(Collectors.toList());
        if (!dtosFilter.isEmpty()) {
            return ResponseEntity.ok(dtosFilter);
        } else {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<CursosDTO>> findById(@PathVariable Long id) {
        Optional<CursosDTO> dto = Optional.ofNullable(service.findById(id));
        return ResponseEntity.ok(dto);
    }


}

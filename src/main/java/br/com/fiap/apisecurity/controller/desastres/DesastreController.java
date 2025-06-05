package br.com.fiap.apisecurity.controller.desastres;

import br.com.fiap.apisecurity.dto.desastres.DesastreDTO;
import br.com.fiap.apisecurity.service.desastres.DesastreService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/desastres")
public class DesastreController {

    private final DesastreService service;

    public DesastreController(DesastreService service) {
        this.service = service;
    }

    @GetMapping
    public List<DesastreDTO> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DesastreDTO> findById(@PathVariable Integer id) {
        DesastreDTO dto = service.findById(id);
        return dto != null ? ResponseEntity.ok(dto) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<DesastreDTO> create(@RequestBody DesastreDTO dto) {
        return ResponseEntity.ok(service.create(dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}

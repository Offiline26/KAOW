package br.com.fiap.apisecurity.controller;

import br.com.fiap.apisecurity.dto.DesastreDTO;
import br.com.fiap.apisecurity.service.DesastreService;
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
    public ResponseEntity<DesastreDTO> findById(@PathVariable Long id) {
        DesastreDTO dto = service.findById(id);
        return dto != null ? ResponseEntity.ok(dto) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<DesastreDTO> create(@RequestBody DesastreDTO dto) {
        return ResponseEntity.ok(service.create(dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}

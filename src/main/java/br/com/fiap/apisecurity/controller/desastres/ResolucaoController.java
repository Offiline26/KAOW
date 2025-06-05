package br.com.fiap.apisecurity.controller.desastres;

import br.com.fiap.apisecurity.dto.desastres.ResolucaoDTO;
import br.com.fiap.apisecurity.service.desastres.ResolucaoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/resolucoes")
public class ResolucaoController {

    private final ResolucaoService service;

    public ResolucaoController(ResolucaoService service) {
        this.service = service;
    }

    @GetMapping
    public List<ResolucaoDTO> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResolucaoDTO> findById(@PathVariable Long id) {
        ResolucaoDTO dto = service.findById(id);
        return dto != null ? ResponseEntity.ok(dto) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<ResolucaoDTO> create(@RequestBody ResolucaoDTO dto) {
        return ResponseEntity.ok(service.create(dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}

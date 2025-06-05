package br.com.fiap.apisecurity.controller.desastres;

import br.com.fiap.apisecurity.dto.desastres.NivelPerigoDTO;
import br.com.fiap.apisecurity.service.desastres.NivelPerigoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/niveis-perigo")
public class NivelPerigoController {

    private final NivelPerigoService service;

    public NivelPerigoController(NivelPerigoService service) {
        this.service = service;
    }

    @GetMapping
    public List<NivelPerigoDTO> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<NivelPerigoDTO> findById(@PathVariable Integer id) {
        NivelPerigoDTO dto = service.findById(id);
        return dto != null ? ResponseEntity.ok(dto) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<NivelPerigoDTO> create(@RequestBody NivelPerigoDTO dto) {
        return ResponseEntity.ok(service.create(dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}

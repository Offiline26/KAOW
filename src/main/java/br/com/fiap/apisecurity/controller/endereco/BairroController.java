package br.com.fiap.apisecurity.controller.endereco;

import br.com.fiap.apisecurity.dto.endereco.BairroDTO;
import br.com.fiap.apisecurity.mapper.endereco.BairroMapper;
import br.com.fiap.apisecurity.model.endereco.Bairro;
import br.com.fiap.apisecurity.service.endereco.BairroService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/bairros")
public class BairroController {

    private final BairroService bairroService;

    public BairroController(BairroService bairroService) {
        this.bairroService = bairroService;
    }

    @GetMapping
    public List<BairroDTO> listarTodos() {
        return bairroService.listarTodos().stream()
                .map(BairroMapper::toDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<BairroDTO> buscarPorId(@PathVariable Long id) {
        return bairroService.buscarPorId(id)
                .map(bairro -> ResponseEntity.ok(BairroMapper.toDTO(bairro)))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<BairroDTO> cadastrar(@RequestBody @Valid BairroDTO dto) {
        Bairro novo = bairroService.salvar(BairroMapper.toEntity(dto));
        return ResponseEntity.ok(BairroMapper.toDTO(novo));
    }
}

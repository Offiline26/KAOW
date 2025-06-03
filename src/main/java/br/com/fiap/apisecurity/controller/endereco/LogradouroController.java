package br.com.fiap.apisecurity.controller.endereco;

import br.com.fiap.apisecurity.dto.endereco.LogradouroDTO;
import br.com.fiap.apisecurity.mapper.endereco.LogradouroMapper;
import br.com.fiap.apisecurity.model.endereco.Logradouro;
import br.com.fiap.apisecurity.service.endereco.LogradouroService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/logradouros")
public class LogradouroController {

    private final LogradouroService logradouroService;

    public LogradouroController(LogradouroService logradouroService) {
        this.logradouroService = logradouroService;
    }

    @GetMapping
    public List<LogradouroDTO> listarTodos() {
        return logradouroService.listarTodos().stream()
                .map(LogradouroMapper::toDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<LogradouroDTO> buscarPorId(@PathVariable Long id) {
        return logradouroService.buscarPorId(id)
                .map(logradouro -> ResponseEntity.ok(LogradouroMapper.toDTO(logradouro)))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<LogradouroDTO> cadastrar(@RequestBody @Valid LogradouroDTO dto) {
        Logradouro novo = logradouroService.salvar(LogradouroMapper.toEntity(dto));
        return ResponseEntity.ok(LogradouroMapper.toDTO(novo));
    }
}

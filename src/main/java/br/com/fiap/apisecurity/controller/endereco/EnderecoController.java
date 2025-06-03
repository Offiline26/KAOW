package br.com.fiap.apisecurity.controller.endereco;

import br.com.fiap.apisecurity.dto.endereco.EnderecoDTO;
import br.com.fiap.apisecurity.mapper.endereco.EnderecoMapper;
import br.com.fiap.apisecurity.model.endereco.Endereco;
import br.com.fiap.apisecurity.service.endereco.EnderecoService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/enderecos")
public class EnderecoController {

    private final EnderecoService enderecoService;

    public EnderecoController(EnderecoService enderecoService) {
        this.enderecoService = enderecoService;
    }

    @GetMapping
    public List<EnderecoDTO> listarTodos() {
        return enderecoService.listarTodos().stream()
                .map(EnderecoMapper::toDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EnderecoDTO> buscarPorId(@PathVariable Long id) {
        return enderecoService.buscarPorId(id)
                .map(endereco -> ResponseEntity.ok(EnderecoMapper.toDTO(endereco)))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<EnderecoDTO> cadastrar(@RequestBody @Valid EnderecoDTO dto) {
        Endereco novo = enderecoService.salvar(EnderecoMapper.toEntity(dto));
        return ResponseEntity.ok(EnderecoMapper.toDTO(novo));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EnderecoDTO> atualizar(@PathVariable Long id, @RequestBody @Valid EnderecoDTO dto) {
        Endereco endereco = EnderecoMapper.toEntity(dto);
        Endereco atualizado = enderecoService.atualizar(id, endereco);
        return ResponseEntity.ok(EnderecoMapper.toDTO(atualizado));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        enderecoService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}

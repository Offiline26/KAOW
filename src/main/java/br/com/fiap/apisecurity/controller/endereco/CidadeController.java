package br.com.fiap.apisecurity.controller.endereco;

import br.com.fiap.apisecurity.dto.endereco.CidadeDTO;
import br.com.fiap.apisecurity.mapper.endereco.CidadeMapper;
import br.com.fiap.apisecurity.model.endereco.Cidade;
import br.com.fiap.apisecurity.service.endereco.CidadeService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/cidades")
public class CidadeController {

    private final CidadeService cidadeService;

    public CidadeController(CidadeService cidadeService) {
        this.cidadeService = cidadeService;
    }

    @GetMapping
    public List<CidadeDTO> listarTodas() {
        return cidadeService.listarTodas().stream()
                .map(CidadeMapper::toDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CidadeDTO> buscarPorId(@PathVariable Long id) {
        return cidadeService.buscarPorId(id)
                .map(cidade -> ResponseEntity.ok(CidadeMapper.toDTO(cidade)))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<CidadeDTO> cadastrar(@RequestBody @Valid CidadeDTO dto) {
        Cidade nova = cidadeService.salvar(CidadeMapper.toEntity(dto));
        return ResponseEntity.ok(CidadeMapper.toDTO(nova));
    }

}

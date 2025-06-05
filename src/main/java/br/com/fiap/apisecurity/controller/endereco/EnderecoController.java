package br.com.fiap.apisecurity.controller.endereco;

import br.com.fiap.apisecurity.dto.endereco.EnderecoRequest;
import br.com.fiap.apisecurity.dto.endereco.EnderecoResponse;
import br.com.fiap.apisecurity.service.endereco.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/enderecos")
public class EnderecoController {

    @Autowired
    private EnderecoService service;

    @PostMapping
    public ResponseEntity<EnderecoResponse> criar(@RequestBody EnderecoRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.criar(request));
    }

    @GetMapping
    public ResponseEntity<List<EnderecoResponse>> listarTodos() {
        return ResponseEntity.ok(service.listarTodos());
    }
}

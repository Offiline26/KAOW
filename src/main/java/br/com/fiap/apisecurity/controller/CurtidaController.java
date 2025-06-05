package br.com.fiap.apisecurity.controller;

import br.com.fiap.apisecurity.dto.CurtidaRequest;
import br.com.fiap.apisecurity.dto.CurtidaResponse;
import br.com.fiap.apisecurity.service.CurtidaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/curtidas")
public class CurtidaController {

    @Autowired private CurtidaService service;

    @PostMapping
    public ResponseEntity<CurtidaResponse> curtir(@RequestBody CurtidaRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.curtir(request));
    }

    @GetMapping("/postagem/{id}")
    public ResponseEntity<List<CurtidaResponse>> listarPorPostagem(@PathVariable Integer id) {
        return ResponseEntity.ok(service.listarPorPostagem(id));
    }

    @DeleteMapping
    public ResponseEntity<Void> remover(@RequestParam Integer idUsuario, @RequestParam Integer idPostagem) {
        service.removerCurtida(idUsuario, idPostagem);
        return ResponseEntity.noContent().build();
    }
}

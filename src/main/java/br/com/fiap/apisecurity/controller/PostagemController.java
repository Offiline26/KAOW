package br.com.fiap.apisecurity.controller;

import br.com.fiap.apisecurity.dto.PostagemRequest;
import br.com.fiap.apisecurity.dto.PostagemResponse;
import br.com.fiap.apisecurity.service.PostagemService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/postagens")
public class PostagemController {

    @Autowired private PostagemService service;

    @PostMapping
    public ResponseEntity<PostagemResponse> criar(@RequestBody PostagemRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.criarPostagem(request));
    }

    @GetMapping
    public ResponseEntity<List<PostagemResponse>> listar() {
        return ResponseEntity.ok(service.listarPostagens());
    }
}

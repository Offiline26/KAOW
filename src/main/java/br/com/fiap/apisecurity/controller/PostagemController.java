package br.com.fiap.apisecurity.controller;

import br.com.fiap.apisecurity.dto.PostagemRequest;
import br.com.fiap.apisecurity.dto.PostagemResponse;
import br.com.fiap.apisecurity.model.Postagem;
import br.com.fiap.apisecurity.repository.PostagemRepository;
import br.com.fiap.apisecurity.service.PostagemService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/postagens")
public class PostagemController {

    @Autowired private PostagemService service;
    @Autowired private PostagemRepository repository;
    @Autowired private PostagemService postagemService;

    @PostMapping
    public ResponseEntity<PostagemResponse> criar(@RequestBody PostagemRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.criarPostagem(request));
    }

    @GetMapping
    public ResponseEntity<List<PostagemResponse>> listar() {
        return ResponseEntity.ok(service.listarPostagens());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PostagemResponse> getPostDetalhes(@PathVariable Integer id) {
        Optional<Postagem> postagemOpt = repository.findByIdWithDetails(id);
        return postagemOpt.map(postagem -> ResponseEntity.ok(postagemService.montarDetalhesPostagem(postagem)))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }
}

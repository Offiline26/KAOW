package br.com.fiap.apisecurity.controller.postagem;

import br.com.fiap.apisecurity.dto.postagem.PostagemRequest;
import br.com.fiap.apisecurity.dto.postagem.PostagemResponse;
import br.com.fiap.apisecurity.model.postagem.Postagem;
import br.com.fiap.apisecurity.repository.postagem.PostagemRepository;
import br.com.fiap.apisecurity.service.postagem.PostagemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
        return postagemOpt.map(postagem -> ResponseEntity.ok(postagemService.montarDetalhesPostagem(id)))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }
}

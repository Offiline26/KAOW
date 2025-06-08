package br.com.fiap.apisecurity.controller.postagem;

import br.com.fiap.apisecurity.dto.postagem.ComentarioRequest;
import br.com.fiap.apisecurity.dto.postagem.ComentarioResponse;
import br.com.fiap.apisecurity.service.postagem.ComentarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comentarios")
public class ComentarioController {


    @Autowired private ComentarioService service;

    @PostMapping
    public ResponseEntity<ComentarioResponse> comentar(@RequestBody ComentarioRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.criarComentario(request));
    }

    @GetMapping("/postagem/{id}")
    public ResponseEntity<List<ComentarioResponse>> listarPorPostagem(@PathVariable Integer id) {
        return ResponseEntity.ok(service.listarPorPostagem(id));
    }
}

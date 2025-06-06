package br.com.fiap.apisecurity.controller;

import br.com.fiap.apisecurity.dto.CurtidaRequest;
import br.com.fiap.apisecurity.dto.CurtidaResponse;
import br.com.fiap.apisecurity.model.usuarios.Usuario;
import br.com.fiap.apisecurity.repository.usuario.UsuarioRepository;
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

    @Autowired
    private CurtidaService curtidaService;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping("/{idPostagem}")
    public ResponseEntity<String> curtirOuDescurtir(
            @PathVariable Integer idPostagem,
            @AuthenticationPrincipal UserDetails userDetails) {

        Usuario usuario = usuarioRepository.findByNomeUsuario(userDetails.getUsername())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        String mensagem = curtidaService.curtirOuDescurtir(idPostagem, usuario);
        return ResponseEntity.ok(mensagem);
    }
}

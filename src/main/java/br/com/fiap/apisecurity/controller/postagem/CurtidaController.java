package br.com.fiap.apisecurity.controller.postagem;

import br.com.fiap.apisecurity.model.usuarios.Usuario;
import br.com.fiap.apisecurity.repository.usuario.UsuarioRepository;
import br.com.fiap.apisecurity.service.postagem.CurtidaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

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

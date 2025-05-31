package br.com.fiap.apisecurity.controller;

import br.com.fiap.apisecurity.dto.LoginRequest;
import br.com.fiap.apisecurity.dto.LoginResponse;
import br.com.fiap.apisecurity.model.Usuario;
import br.com.fiap.apisecurity.repository.UsuarioRepository;
import br.com.fiap.apisecurity.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest login) {
        Optional<Usuario> usuarioOpt = usuarioRepository.findByNomeUsuario(login.getNomeUsuario());

        if (usuarioOpt.isEmpty()) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Usuário não encontrado");
        }

        Usuario usuario = usuarioOpt.get();

        // Comparação simples de senha (texto puro)
        if (!usuario.getSenha().equals(login.getSenha())) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Senha incorreta");
        }

        String token = jwtService.generateToken(usuario.getNomeUsuario());
        return ResponseEntity.ok(new LoginResponse(token, usuario));
    }
}

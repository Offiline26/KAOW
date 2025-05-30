package br.com.fiap.apisecurity.controller;

import br.com.fiap.apisecurity.dto.LoginRequest;
import br.com.fiap.apisecurity.dto.LoginResponse;
import br.com.fiap.apisecurity.repository.UsuarioRepository;
import br.com.fiap.apisecurity.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    JwtService jwtService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest login) {
        var usuario = usuarioRepository.findByNomeUsuario(login.getNomeUsuario());

        if (usuario.isEmpty()) return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Usuário não encontrado");

        if (!usuario.get().getSenha().equals(login.getSenha()))
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Senha incorreta");

        String token = jwtService.generateToken(usuario.get().getNomeUsuario());
        return ResponseEntity.ok(new LoginResponse(token, usuario.get()));
    }
}

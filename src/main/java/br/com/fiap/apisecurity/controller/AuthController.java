package br.com.fiap.apisecurity.controller;

import br.com.fiap.apisecurity.dto.ErrorResponse;
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
        System.out.println("Tentando login para: " + login.getNomeUsuario());
        var usuario = usuarioRepository.findByNomeUsuario(login.getNomeUsuario());

        if (usuario.isEmpty()) {
            System.out.println("Usuário não encontrado");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(new ErrorResponse("Usuário não encontrado"));
        }

        if (!usuario.get().getSenha().equals(login.getSenha())) {
            System.out.println("Senha incorreta");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(new ErrorResponse("Senha incorreta"));
        }

        String token = jwtService.generateToken(usuario.get().getNomeUsuario());
        System.out.println("Login bem sucedido para: " + login.getNomeUsuario());
        return ResponseEntity.ok(new LoginResponse(token, usuario.get()));
    }

}

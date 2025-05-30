package br.com.fiap.apisecurity.controller;

import br.com.fiap.apisecurity.dto.LoginRequest;
import br.com.fiap.apisecurity.dto.LoginResponse;
import br.com.fiap.apisecurity.dto.UsuarioDTO;
import br.com.fiap.apisecurity.mapper.UsuarioMapper;
import br.com.fiap.apisecurity.model.Usuario;
import br.com.fiap.apisecurity.repository.UsuarioRepository;
import br.com.fiap.apisecurity.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin(origins = "*")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/cadastro")
    public ResponseEntity<UsuarioDTO> cadastrar(@RequestBody UsuarioDTO dto) {
        Usuario user = usuarioService.cadastrar(dto);
        UsuarioDTO response = UsuarioMapper.toDto(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}



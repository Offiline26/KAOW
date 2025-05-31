package br.com.fiap.apisecurity.controller;

import br.com.fiap.apisecurity.dto.UsuarioDTO;
import br.com.fiap.apisecurity.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin(origins = "*")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<UsuarioDTO> cadastrar(@RequestBody UsuarioDTO usuarioDTO) {
        UsuarioDTO dtoSalvo = usuarioService.cadastrar(usuarioDTO);
        return ResponseEntity.status(201).body(dtoSalvo);
    }
}



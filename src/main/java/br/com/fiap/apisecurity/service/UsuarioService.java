package br.com.fiap.apisecurity.service;

import br.com.fiap.apisecurity.dto.UsuarioDTO;
import br.com.fiap.apisecurity.mapper.UsuarioMapper;
import br.com.fiap.apisecurity.model.Usuario;
import br.com.fiap.apisecurity.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario cadastrar(UsuarioDTO dto) {
        if (usuarioRepository.existsByEmail(dto.getEmail())) {
            throw new RuntimeException("Email já cadastrado");
        }

        if (usuarioRepository.existsByNomeUsuario(dto.getNomeUsuario())) {
            throw new RuntimeException("Nome de usuário já está em uso");
        }

        Usuario novo = UsuarioMapper.toEntity(dto);
        return usuarioRepository.save(novo);

    }
}




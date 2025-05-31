package br.com.fiap.apisecurity.service;

import br.com.fiap.apisecurity.dto.UsuarioDTO;
import br.com.fiap.apisecurity.mapper.UsuarioMapper;
import br.com.fiap.apisecurity.model.TipoUsuario;
import br.com.fiap.apisecurity.model.Usuario;
import br.com.fiap.apisecurity.repository.TipoUsuarioRepository;
import br.com.fiap.apisecurity.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final TipoUsuarioRepository tipoUsuarioRepository;
    private final UsuarioMapper usuarioMapper;
    private final PasswordEncoder passwordEncoder;

    public UsuarioService(UsuarioRepository usuarioRepository, TipoUsuarioRepository tipoUsuarioRepository,
                          UsuarioMapper usuarioMapper, PasswordEncoder passwordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.tipoUsuarioRepository = tipoUsuarioRepository;
        this.usuarioMapper = usuarioMapper;
        this.passwordEncoder = passwordEncoder;
    }

    public UsuarioDTO cadastrarUsuario(UsuarioDTO dto) {
        TipoUsuario tipo = tipoUsuarioRepository.findById(dto.getIdTipoUsuario())
                .orElseThrow(() -> new RuntimeException("Tipo de usuário inválido"));

        dto.setSenha(passwordEncoder.encode(dto.getSenha()));

        Usuario usuario = usuarioMapper.toEntity(dto, tipo);
        Usuario salvo = usuarioRepository.save(usuario);

        return usuarioMapper.toDTO(salvo);
    }
}





package br.com.fiap.apisecurity.service;

import br.com.fiap.apisecurity.dto.UsuarioDTO;
import br.com.fiap.apisecurity.mapper.UsuarioMapper;
import br.com.fiap.apisecurity.model.Usuario;
import br.com.fiap.apisecurity.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final UsuarioMapper usuarioMapper;
    private final PasswordEncoder passwordEncoder;

    public UsuarioService(UsuarioRepository usuarioRepository, UsuarioMapper usuarioMapper, PasswordEncoder passwordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.usuarioMapper = usuarioMapper;
        this.passwordEncoder = passwordEncoder;
    }

    public UsuarioDTO cadastrarUsuario(UsuarioDTO dto) {
        // Converte DTO para entidade
        Usuario usuario = usuarioMapper.toEntity(dto);

        // Codifica a senha antes de salvar
        String senhaCodificada = passwordEncoder.encode(dto.getSenha());
        usuario.setSenha(senhaCodificada);

        // Salva no banco
        Usuario salvo = usuarioRepository.save(usuario);

        // Converte entidade salva para DTO e retorna
        return usuarioMapper.toDTO(salvo);
    }
}





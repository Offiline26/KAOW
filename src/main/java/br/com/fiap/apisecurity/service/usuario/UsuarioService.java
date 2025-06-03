package br.com.fiap.apisecurity.service.usuario;


import br.com.fiap.apisecurity.dto.usuario.UsuarioDTO;
import br.com.fiap.apisecurity.mapper.usuario.UsuarioMapper;
import br.com.fiap.apisecurity.model.usuarios.TipoUsuario;
import br.com.fiap.apisecurity.model.usuarios.Usuario;
import br.com.fiap.apisecurity.repository.usuario.TipoUsuarioRepository;
import br.com.fiap.apisecurity.repository.usuario.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final TipoUsuarioRepository tipoUsuarioRepository;
    private final UsuarioMapper mapper;
    private final PasswordEncoder passwordEncoder;

    //Comentario
    @Autowired
    public UsuarioService(
            UsuarioRepository usuarioRepository,
            TipoUsuarioRepository tipoUsuarioRepository,
            UsuarioMapper mapper,
            PasswordEncoder passwordEncoder
    ) {
        this.usuarioRepository = usuarioRepository;
        this.tipoUsuarioRepository = tipoUsuarioRepository;
        this.mapper = mapper;
        this.passwordEncoder = passwordEncoder;
    }

    public Usuario salvar(UsuarioDTO dto) {
        TipoUsuario tipo = tipoUsuarioRepository.findById(dto.getIdTipoUsuario().longValue())
                .orElseThrow(() -> new RuntimeException("TipoUsuario nao encontrado"));

        Usuario usuario = mapper.toEntity(dto, tipo);
        usuario.setSenha(passwordEncoder.encode(dto.getSenha()));

        return usuarioRepository.save(usuario);
    }
}





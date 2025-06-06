package br.com.fiap.apisecurity.service.usuario;


import br.com.fiap.apisecurity.dto.PostagemPerfilResponse;
import br.com.fiap.apisecurity.dto.usuario.UsuarioDTO;
import br.com.fiap.apisecurity.dto.usuario.UsuarioPerfilResponse;
import br.com.fiap.apisecurity.mapper.usuario.UsuarioMapper;
import br.com.fiap.apisecurity.model.usuarios.TipoUsuario;
import br.com.fiap.apisecurity.model.usuarios.Usuario;
import br.com.fiap.apisecurity.repository.usuario.TipoUsuarioRepository;
import br.com.fiap.apisecurity.repository.usuario.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Random;

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
        usuario.setCorPerfil(gerarCorHexAleatoria());

        return usuarioRepository.save(usuario);
    }

    private String gerarCorHexAleatoria() {
        Random random = new Random();
        int r = random.nextInt(256);
        int g = random.nextInt(256);
        int b = random.nextInt(256);
        return String.format("#%02X%02X%02X", r, g, b);
    }

    @Transactional
    public UsuarioPerfilResponse montarPerfilParaFrontend(Usuario usuario) {
        // Força carregamento das postagens e curtidas enquanto a sessão estiver ativa
        usuario.getPostagens().forEach(postagem -> postagem.getCurtidas().size());

        UsuarioPerfilResponse perfil = new UsuarioPerfilResponse();
        perfil.setNome_usuario(usuario.getNomeUsuario());
        perfil.setCor_perfil(usuario.getCorPerfil());
        perfil.setIdTipoUsuario(usuario.getTipoUsuario().getId());

        List<PostagemPerfilResponse> postagens = usuario.getPostagens().stream().map(post -> {
            PostagemPerfilResponse dto = new PostagemPerfilResponse();
            dto.setId_postagem(post.getId());
            dto.setConteudo(post.getConteudo());
            dto.setIdResolucao(post.getResolucao().getId());
            dto.setStatusResolucao(post.getResolucao().getStatus());
            dto.setDataPublicacao(post.getDataPublicacao());

            PostagemPerfilResponse.EnderecoDTO enderecoDTO = new PostagemPerfilResponse.EnderecoDTO();
            enderecoDTO.setBairro(post.getEndereco().getBairro());
            enderecoDTO.setLogradouro(post.getEndereco().getLogradouro());
            dto.setEndereco(enderecoDTO);

            dto.setCurtidas(post.getCurtidas().stream()
                    .map(c -> c.getUsuario().getId())
                    .toList());

            return dto;
        }).toList();

        perfil.setPostagens(postagens);
        return perfil;
    }
}





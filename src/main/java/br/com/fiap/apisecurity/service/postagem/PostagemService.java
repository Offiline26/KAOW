package br.com.fiap.apisecurity.service.postagem;

import br.com.fiap.apisecurity.dto.postagem.ComentarioResponse;
import br.com.fiap.apisecurity.dto.postagem.PostagemRequest;
import br.com.fiap.apisecurity.dto.postagem.PostagemResponse;
import br.com.fiap.apisecurity.dto.endereco.EnderecoResponse;
import br.com.fiap.apisecurity.mapper.postagem.PostagemMapper;
import br.com.fiap.apisecurity.model.postagem.Postagem;
import br.com.fiap.apisecurity.model.endereco.Endereco;
import br.com.fiap.apisecurity.repository.postagem.PostagemRepository;
import br.com.fiap.apisecurity.repository.desastres.DesastreRepository;
import br.com.fiap.apisecurity.repository.desastres.NivelPerigoRepository;
import br.com.fiap.apisecurity.repository.desastres.ResolucaoRepository;
import br.com.fiap.apisecurity.repository.endereco.EnderecoRepository;
import br.com.fiap.apisecurity.repository.usuario.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostagemService {

    @Autowired private PostagemRepository repository;
    @Autowired private ResolucaoRepository resolucaoRepo;
    @Autowired private UsuarioRepository usuarioRepo;
    @Autowired private EnderecoRepository enderecoRepo;
    @Autowired private DesastreRepository desastreRepo;
    @Autowired private NivelPerigoRepository nivelRepo;

    public PostagemResponse criarPostagem(PostagemRequest request) {
        var resolucao = resolucaoRepo.findById(request.getIdResolucao())
                .orElseThrow(() -> new RuntimeException("Resolução não encontrada"));

        var usuario = usuarioRepo.findById(request.getIdUsuario())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        Endereco endereco = new Endereco();
        endereco.setPais("Brasil");
        endereco.setEstado("SP");
        endereco.setCidade("São Paulo");
        endereco.setBairro(request.getEndereco().getBairro());
        endereco.setLogradouro(request.getEndereco().getLogradouro());
        enderecoRepo.save(endereco);

        var desastre = desastreRepo.findById(request.getIdDesastre())
                .orElseThrow(() -> new RuntimeException("Desastre não encontrado"));

        var nivel = nivelRepo.findById(request.getIdNivelPerigo())
                .orElseThrow(() -> new RuntimeException("Nível de perigo não encontrado"));

        var postagem = PostagemMapper.toEntity(request, resolucao, usuario, endereco, desastre, nivel);
        repository.save(postagem);
        return PostagemMapper.toResponse(postagem);
    }

    public List<PostagemResponse> listarPostagens() {
        return repository.findAll()
                .stream()
                .map(PostagemMapper::toResponse)
                .toList();
    }

    @Transactional
    public PostagemResponse montarDetalhesPostagem(Integer id) {
        Postagem postagem = repository.findByIdWithDetails(id)
                .orElseThrow(() -> new RuntimeException("Postagem não encontrada"));

        PostagemResponse response = new PostagemResponse();
        response.setId(postagem.getId());
        response.setConteudo(postagem.getConteudo());
        response.setStatusResolucao(postagem.getResolucao().getStatus());
        response.setDataPublicacao(postagem.getDataPublicacao());

        // Montando o endereço
        EnderecoResponse enderecoResponse = new EnderecoResponse();
        enderecoResponse.setId(postagem.getEndereco().getId());
        enderecoResponse.setBairro(postagem.getEndereco().getBairro());
        enderecoResponse.setLogradouro(postagem.getEndereco().getLogradouro());
        enderecoResponse.setCidade(postagem.getEndereco().getCidade());
        enderecoResponse.setEstado(postagem.getEndereco().getEstado());
        enderecoResponse.setPais(postagem.getEndereco().getPais());
        response.setEndereco(enderecoResponse);

        // Adicionando o usuário
        if (postagem.getUsuario() != null) {
            response.setNomeUsuario(postagem.getUsuario().getNomeUsuario()); // Nome do usuário
            response.setIdUsuario(postagem.getUsuario().getId());
            // Se você quiser adicionar mais informações sobre o usuário, como "corPerfil" ou "idTipoUsuario", pode adicionar também
        }

        // Curtidas
        response.setCurtidas(postagem.getCurtidas().stream()
                .map(c -> c.getUsuario().getId())
                .collect(Collectors.toList()));

        // Comentários
        response.setComentarios(postagem.getComentarios().stream()
                .map(c -> {
                    ComentarioResponse comentarioDTO = new ComentarioResponse();
                    comentarioDTO.setId(c.getId());
                    comentarioDTO.setTexto(c.getTexto());
                    comentarioDTO.setDataComentario(c.getDataComentario());
                    return comentarioDTO;
                })
                .collect(Collectors.toList()));

        // Desastre
        if (postagem.getDesastre() != null) {
            response.setDesastre(postagem.getDesastre().getTipo());
        }

        // Nivel Perigo
        if (postagem.getNivelPerigo() != null) {
            response.setNivelPerigo(postagem.getNivelPerigo().getNivel());
        }

        return response;
    }
}


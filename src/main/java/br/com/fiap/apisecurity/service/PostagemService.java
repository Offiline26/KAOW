package br.com.fiap.apisecurity.service;

import br.com.fiap.apisecurity.dto.PostagemRequest;
import br.com.fiap.apisecurity.dto.PostagemResponse;
import br.com.fiap.apisecurity.mapper.PostagemMapper;

import br.com.fiap.apisecurity.model.endereco.Endereco;
import br.com.fiap.apisecurity.repository.PostagemRepository;

import br.com.fiap.apisecurity.repository.desastres.DesastreRepository;
import br.com.fiap.apisecurity.repository.desastres.NivelPerigoRepository;
import br.com.fiap.apisecurity.repository.desastres.ResolucaoRepository;
import br.com.fiap.apisecurity.repository.endereco.EnderecoRepository;
import br.com.fiap.apisecurity.repository.usuario.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
}


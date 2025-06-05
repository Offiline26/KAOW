package br.com.fiap.apisecurity.service;

import br.com.fiap.apisecurity.dto.CurtidaRequest;
import br.com.fiap.apisecurity.dto.CurtidaResponse;
import br.com.fiap.apisecurity.mapper.CurtidaMapper;
import br.com.fiap.apisecurity.model.Curtida;
import br.com.fiap.apisecurity.repository.CurtidaRepository;
import br.com.fiap.apisecurity.repository.PostagemRepository;
import br.com.fiap.apisecurity.repository.usuario.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class CurtidaService {

    @Autowired private CurtidaRepository curtidaRepo;
    @Autowired private UsuarioRepository usuarioRepo;
    @Autowired private PostagemRepository postagemRepo;

    public CurtidaResponse curtir(CurtidaRequest request) {
        var usuario = usuarioRepo.findById(request.getIdUsuario()).orElseThrow();
        var postagem = postagemRepo.findById(request.getIdPostagem()).orElseThrow();

        boolean jaCurtiu = curtidaRepo.existsByUsuarioIdAndPostagemId(usuario.getId(), postagem.getId());
        if (jaCurtiu) throw new RuntimeException("Usuário já curtiu essa postagem.");

        Curtida curtida = CurtidaMapper.toEntity(request, usuario, postagem);
        curtidaRepo.save(curtida);
        return CurtidaMapper.toResponse(curtida);
    }

    public List<CurtidaResponse> listarPorPostagem(Integer idPostagem) {
        return curtidaRepo.findByPostagemId(idPostagem)
                .stream()
                .map(CurtidaMapper::toResponse)
                .toList();
    }

    public void removerCurtida(Integer idUsuario, Integer idPostagem) {
        curtidaRepo.deleteByUsuarioIdAndPostagemId(idUsuario, idPostagem);
    }
}
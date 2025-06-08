package br.com.fiap.apisecurity.service.postagem;

import br.com.fiap.apisecurity.dto.postagem.ComentarioRequest;
import br.com.fiap.apisecurity.dto.postagem.ComentarioResponse;
import br.com.fiap.apisecurity.mapper.postagem.ComentarioMapper;
import br.com.fiap.apisecurity.model.postagem.Comentario;
import br.com.fiap.apisecurity.repository.postagem.ComentarioRepository;
import br.com.fiap.apisecurity.repository.postagem.PostagemRepository;
import br.com.fiap.apisecurity.repository.usuario.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComentarioService {

    @Autowired private ComentarioRepository comentarioRepo;
    @Autowired private UsuarioRepository usuarioRepo;
    @Autowired private PostagemRepository postagemRepo;

    public ComentarioResponse criarComentario(ComentarioRequest request) {
        var usuario = usuarioRepo.findById(request.getIdUsuario()).orElseThrow();
        var postagem = postagemRepo.findById(request.getIdPostagem()).orElseThrow();

        Comentario comentario = ComentarioMapper.toEntity(request, usuario, postagem);
        comentarioRepo.save(comentario);
        return ComentarioMapper.toResponse(comentario);
    }

    public Page<ComentarioResponse> listarPorPostagem(Integer idPostagem, Pageable pageable) {
        return comentarioRepo.findByPostagemId(idPostagem, pageable)
                .map(ComentarioMapper::toResponse);
    }
}

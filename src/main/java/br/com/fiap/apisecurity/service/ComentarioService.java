package br.com.fiap.apisecurity.service;

import br.com.fiap.apisecurity.dto.ComentarioRequest;
import br.com.fiap.apisecurity.dto.ComentarioResponse;
import br.com.fiap.apisecurity.mapper.ComentarioMapper;
import br.com.fiap.apisecurity.model.Comentario;
import br.com.fiap.apisecurity.model.Postagem;
import br.com.fiap.apisecurity.model.usuarios.Usuario;
import br.com.fiap.apisecurity.repository.ComentarioRepository;
import br.com.fiap.apisecurity.repository.PostagemRepository;
import br.com.fiap.apisecurity.repository.usuario.UsuarioRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import java.time.LocalDate;

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

    public List<ComentarioResponse> listarPorPostagem(Integer idPostagem) {
        return comentarioRepo.findByPostagemId(idPostagem)
                .stream()
                .map(ComentarioMapper::toResponse)
                .toList();
    }
}

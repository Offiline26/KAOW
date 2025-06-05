package br.com.fiap.apisecurity.mapper;

import br.com.fiap.apisecurity.dto.ComentarioRequest;
import br.com.fiap.apisecurity.dto.ComentarioResponse;
import br.com.fiap.apisecurity.model.Comentario;
import br.com.fiap.apisecurity.model.Postagem;
import br.com.fiap.apisecurity.model.usuarios.Usuario;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class ComentarioMapper {

    public static Comentario toEntity(ComentarioRequest req, Usuario usuario, Postagem postagem) {
        Comentario comentario = new Comentario();
        comentario.setTexto(req.getTexto());
        comentario.setUsuario(usuario);
        comentario.setPostagem(postagem);
        comentario.setDataComentario(LocalDateTime.now());
        return comentario;
    }

    public static ComentarioResponse toResponse(Comentario comentario) {
        ComentarioResponse resp = new ComentarioResponse();
        resp.setId(comentario.getId());
        resp.setTexto(comentario.getTexto());
        resp.setDataComentario(comentario.getDataComentario());
        resp.setNomeUsuario(comentario.getUsuario().getNomeUsuario());
        resp.setIdPostagem(comentario.getPostagem().getId());
        return resp;
    }
}


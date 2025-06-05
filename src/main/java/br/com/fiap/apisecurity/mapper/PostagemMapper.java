package br.com.fiap.apisecurity.mapper;

import br.com.fiap.apisecurity.dto.ComentarioResponse;
import br.com.fiap.apisecurity.dto.PostagemRequest;
import br.com.fiap.apisecurity.dto.PostagemResponse;
import br.com.fiap.apisecurity.mapper.endereco.EnderecoMapper;
import br.com.fiap.apisecurity.model.Postagem;
import br.com.fiap.apisecurity.model.desastres.Desastre;
import br.com.fiap.apisecurity.model.desastres.NivelPerigo;
import br.com.fiap.apisecurity.model.desastres.Resolucao;
import br.com.fiap.apisecurity.model.endereco.Endereco;
import br.com.fiap.apisecurity.model.usuarios.Usuario;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class PostagemMapper {

    public static Postagem toEntity(PostagemRequest request, Resolucao resolucao, Usuario usuario,
                                    Endereco endereco, Desastre desastre, NivelPerigo nivel) {
        Postagem postagem = new Postagem();
        postagem.setConteudo(request.getConteudo());
        postagem.setResolucao(resolucao);
        postagem.setUsuario(usuario);
        postagem.setEndereco(endereco);
        postagem.setDesastre(desastre);
        postagem.setNivelPerigo(nivel);
        return postagem;
    }

    public static PostagemResponse toResponse(Postagem postagem) {
        PostagemResponse resp = new PostagemResponse();
        resp.setId(postagem.getId());
        resp.setConteudo(postagem.getConteudo());
        resp.setNomeUsuario(postagem.getUsuario().getNomeUsuario());
        resp.setEndereco(EnderecoMapper.toResponse(postagem.getEndereco()));
        resp.setDesastre(postagem.getDesastre().getTipo());
        resp.setNivelPerigo(postagem.getNivelPerigo().getNivel());
        resp.setStatusResolucao(postagem.getResolucao().getStatus());
        return resp;
    }
}



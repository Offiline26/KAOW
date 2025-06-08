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
        postagem.setDataPublicacao(LocalDateTime.now());
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
        resp.setDataPublicacao(postagem.getDataPublicacao());
        // Verifica se usuario é nulo para evitar NullPointerException
        resp.setNomeUsuario(postagem.getUsuario() != null ? postagem.getUsuario().getNomeUsuario() : "Desconhecido");
        resp.setIdUsuario(postagem.getUsuario().getId());

        // Verifica se o endereco está presente e mapeia com o endereço correto
        resp.setEndereco(postagem.getEndereco() != null ? EnderecoMapper.toResponse(postagem.getEndereco()) : null);

        // Verifica se desastre está presente
        resp.setDesastre(postagem.getDesastre() != null ? postagem.getDesastre().getTipo() : "Desastre desconhecido");

        // Verifica se o nivelPerigo está presente
        resp.setNivelPerigo(postagem.getNivelPerigo() != null ? postagem.getNivelPerigo().getNivel() : "Nível desconhecido");

        // Verifica se a resolução está presente
        resp.setStatusResolucao(postagem.getResolucao() != null ? postagem.getResolucao().getStatus() : "Status não disponível");

        return resp;
    }
}



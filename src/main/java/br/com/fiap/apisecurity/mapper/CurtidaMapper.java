package br.com.fiap.apisecurity.mapper;

import br.com.fiap.apisecurity.dto.CurtidaRequest;
import br.com.fiap.apisecurity.dto.CurtidaResponse;
import br.com.fiap.apisecurity.model.Curtida;
import br.com.fiap.apisecurity.model.Postagem;
import br.com.fiap.apisecurity.model.usuarios.Usuario;
import org.springframework.stereotype.Component;

@Component
public class CurtidaMapper {

    public static Curtida toEntity(CurtidaRequest request, Usuario usuario, Postagem postagem) {
        Curtida curtida = new Curtida();
        curtida.setUsuario(usuario);
        curtida.setPostagem(postagem);
        return curtida;
    }

    public static CurtidaResponse toResponse(Curtida curtida) {
        CurtidaResponse response = new CurtidaResponse();
        response.setId(curtida.getId());
        response.setDataCurtida(curtida.getDataCurtida());
        response.setId(curtida.getUsuario().getId());
        response.setIdPostagem(curtida.getPostagem().getId());
        return response;
    }
}

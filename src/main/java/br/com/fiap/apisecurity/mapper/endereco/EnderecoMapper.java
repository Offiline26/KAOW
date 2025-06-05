package br.com.fiap.apisecurity.mapper.endereco;

import br.com.fiap.apisecurity.dto.endereco.EnderecoRequest;
import br.com.fiap.apisecurity.dto.endereco.EnderecoResponse;
import br.com.fiap.apisecurity.model.endereco.Endereco;

public class EnderecoMapper {

    public static Endereco toEntity(EnderecoRequest request) {
        Endereco endereco = new Endereco();
        endereco.setPais("Brasil");
        endereco.setEstado("SP");
        endereco.setCidade("São Paulo");
        endereco.setBairro(request.getBairro());
        endereco.setLogradouro(request.getLogradouro());
        return endereco;
    }

    public static EnderecoResponse toResponse(Endereco endereco) {
        EnderecoResponse resp = new EnderecoResponse();
        resp.setId(endereco.getId());
        endereco.setPais("Brasil");
        endereco.setEstado("SP");
        endereco.setCidade("São Paulo");
        resp.setBairro(endereco.getBairro());
        resp.setLogradouro(endereco.getLogradouro());
        return resp;
    }
}

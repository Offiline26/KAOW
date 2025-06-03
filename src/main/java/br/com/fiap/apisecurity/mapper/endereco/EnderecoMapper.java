package br.com.fiap.apisecurity.mapper.endereco;

import br.com.fiap.apisecurity.dto.endereco.EnderecoDTO;
import br.com.fiap.apisecurity.model.endereco.Endereco;
import br.com.fiap.apisecurity.model.endereco.Logradouro;

public class EnderecoMapper {

    public static Endereco toEntity(EnderecoDTO dto) {
        Endereco endereco = new Endereco();
        endereco.setId(dto.getId());
        endereco.setNumero(dto.getNumero());
        endereco.setInacessivel(dto.getInacessivel());

        Logradouro logradouro = new Logradouro();
        logradouro.setId(dto.getLogradouroId());
        endereco.setLogradouro(logradouro);

        return endereco;
    }

    public static EnderecoDTO toDTO(Endereco endereco) {
        EnderecoDTO dto = new EnderecoDTO();
        dto.setId(endereco.getId());
        dto.setNumero(endereco.getNumero());
        dto.setInacessivel(endereco.getInacessivel());
        dto.setLogradouroId(endereco.getLogradouro().getId());
        return dto;
    }
}

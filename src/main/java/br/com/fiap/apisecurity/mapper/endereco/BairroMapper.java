package br.com.fiap.apisecurity.mapper.endereco;

import br.com.fiap.apisecurity.dto.endereco.BairroDTO;
import br.com.fiap.apisecurity.model.endereco.Bairro;
import br.com.fiap.apisecurity.model.endereco.Cidade;

public class BairroMapper {

    public static Bairro toEntity(BairroDTO dto) {
        Bairro bairro = new Bairro();
        bairro.setId(dto.getId());
        bairro.setNome(dto.getNome());

        Cidade cidade = new Cidade();
        cidade.setId(dto.getCidadeId());
        bairro.setCidade(cidade);

        return bairro;
    }

    public static BairroDTO toDTO(Bairro bairro) {
        BairroDTO dto = new BairroDTO();
        dto.setId(bairro.getId());
        dto.setNome(bairro.getNome());
        dto.setCidadeId(bairro.getCidade().getId());
        return dto;
    }
}

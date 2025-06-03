package br.com.fiap.apisecurity.mapper.endereco;

import br.com.fiap.apisecurity.dto.endereco.CidadeDTO;
import br.com.fiap.apisecurity.model.endereco.Cidade;

public class CidadeMapper {

    public static CidadeDTO toDTO(Cidade cidade) {
        CidadeDTO dto = new CidadeDTO();
        dto.setId(cidade.getId());
        dto.setCidade(cidade.getCidade());
        return dto;
    }

    public static Cidade toEntity(CidadeDTO dto) {
        Cidade cidade = new Cidade();
        cidade.setId(dto.getId());
        cidade.setCidade(dto.getCidade());
        return cidade;
    }
}

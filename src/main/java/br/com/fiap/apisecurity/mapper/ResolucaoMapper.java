package br.com.fiap.apisecurity.mapper;

import br.com.fiap.apisecurity.dto.ResolucaoDTO;
import br.com.fiap.apisecurity.model.Resolucao;

public class ResolucaoMapper {
    public static ResolucaoDTO toDTO(Resolucao entity) {
        ResolucaoDTO dto = new ResolucaoDTO();
        dto.setId(entity.getId());
        dto.setDataResolucao(entity.getDataResolucao());
        dto.setStatus(entity.getStatus());
        return dto;
    }

    public static Resolucao toEntity(ResolucaoDTO dto) {
        Resolucao entity = new Resolucao();
        entity.setId(dto.getId());
        entity.setDataResolucao(dto.getDataResolucao());
        entity.setStatus(dto.getStatus());
        return entity;
    }
}

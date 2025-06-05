package br.com.fiap.apisecurity.mapper.desastres;

import br.com.fiap.apisecurity.dto.desastres.DesastreDTO;
import br.com.fiap.apisecurity.model.desastres.Desastre;

public class DesastreMapper {
    public static DesastreDTO toDTO(Desastre entity) {
        DesastreDTO dto = new DesastreDTO();
        dto.setId(entity.getId());
        dto.setDesastre(entity.getTipo());
        return dto;
    }

    public static Desastre toEntity(DesastreDTO dto) {
        Desastre entity = new Desastre();
        entity.setId(dto.getId());
        entity.setTipo(dto.getDesastre());
        return entity;
    }
}

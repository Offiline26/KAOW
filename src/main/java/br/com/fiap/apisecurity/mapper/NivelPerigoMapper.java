package br.com.fiap.apisecurity.mapper;

import br.com.fiap.apisecurity.dto.NivelPerigoDTO;
import br.com.fiap.apisecurity.model.NivelPerigo;

public class NivelPerigoMapper {
    public static NivelPerigoDTO toDTO(NivelPerigo entity) {
        NivelPerigoDTO dto = new NivelPerigoDTO();
        dto.setId(entity.getId());
        dto.setNivelPerigo(entity.getNivel());
        return dto;
    }

    public static NivelPerigo toEntity(NivelPerigoDTO dto) {
        NivelPerigo entity = new NivelPerigo();
        entity.setId(dto.getId());
        entity.setNivel(dto.getNivelPerigo());
        return entity;
    }
}

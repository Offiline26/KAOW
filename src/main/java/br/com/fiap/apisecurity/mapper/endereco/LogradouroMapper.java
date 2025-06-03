package br.com.fiap.apisecurity.mapper.endereco;

import br.com.fiap.apisecurity.dto.endereco.LogradouroDTO;
import br.com.fiap.apisecurity.model.endereco.Bairro;
import br.com.fiap.apisecurity.model.endereco.Logradouro;

public class LogradouroMapper {

    public static Logradouro toEntity(LogradouroDTO dto) {
        Logradouro logradouro = new Logradouro();
        logradouro.setId(dto.getId());
        logradouro.setNome(dto.getNome());

        Bairro bairro = new Bairro();
        bairro.setId(dto.getBairroId());
        logradouro.setBairro(bairro);

        return logradouro;
    }

    public static LogradouroDTO toDTO(Logradouro logradouro) {
        LogradouroDTO dto = new LogradouroDTO();
        dto.setId(logradouro.getId());
        dto.setNome(logradouro.getNome());
        dto.setBairroId(logradouro.getBairro().getId());
        return dto;
    }
}

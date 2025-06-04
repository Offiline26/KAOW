package br.com.fiap.apisecurity.service;

import br.com.fiap.apisecurity.dto.NivelPerigoDTO;
import br.com.fiap.apisecurity.mapper.NivelPerigoMapper;
import br.com.fiap.apisecurity.model.NivelPerigo;
import br.com.fiap.apisecurity.repository.NivelPerigoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class NivelPerigoService {

    private final NivelPerigoRepository repository;

    public NivelPerigoService(NivelPerigoRepository repository) {
        this.repository = repository;
    }

    public List<NivelPerigoDTO> findAll() {
        return repository.findAll()
                .stream()
                .map(NivelPerigoMapper::toDTO)
                .collect(Collectors.toList());
    }

    public NivelPerigoDTO findById(Long id) {
        return repository.findById(id)
                .map(NivelPerigoMapper::toDTO)
                .orElse(null);
    }

    public NivelPerigoDTO create(NivelPerigoDTO dto) {
        NivelPerigo entity = NivelPerigoMapper.toEntity(dto);
        return NivelPerigoMapper.toDTO(repository.save(entity));
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}

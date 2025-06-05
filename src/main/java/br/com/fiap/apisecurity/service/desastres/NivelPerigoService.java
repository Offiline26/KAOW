package br.com.fiap.apisecurity.service.desastres;

import br.com.fiap.apisecurity.dto.desastres.NivelPerigoDTO;
import br.com.fiap.apisecurity.mapper.desastres.NivelPerigoMapper;
import br.com.fiap.apisecurity.model.desastres.NivelPerigo;
import br.com.fiap.apisecurity.repository.desastres.NivelPerigoRepository;
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

    public NivelPerigoDTO findById(Integer id) {
        return repository.findById(id)
                .map(NivelPerigoMapper::toDTO)
                .orElse(null);
    }

    public NivelPerigoDTO create(NivelPerigoDTO dto) {
        NivelPerigo entity = NivelPerigoMapper.toEntity(dto);
        return NivelPerigoMapper.toDTO(repository.save(entity));
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }
}

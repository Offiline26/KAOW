package br.com.fiap.apisecurity.service.desastres;

import br.com.fiap.apisecurity.dto.desastres.DesastreDTO;
import br.com.fiap.apisecurity.mapper.desastres.DesastreMapper;
import br.com.fiap.apisecurity.model.desastres.Desastre;
import br.com.fiap.apisecurity.repository.desastres.DesastreRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DesastreService {

    private final DesastreRepository repository;

    public DesastreService(DesastreRepository repository) {
        this.repository = repository;
    }

    public List<DesastreDTO> findAll() {
        return repository.findAll()
                .stream()
                .map(DesastreMapper::toDTO)
                .collect(Collectors.toList());
    }

    public DesastreDTO findById(Integer id) {
        return repository.findById(id)
                .map(DesastreMapper::toDTO)
                .orElse(null);
    }

    public DesastreDTO create(DesastreDTO dto) {
        Desastre entity = DesastreMapper.toEntity(dto);
        return DesastreMapper.toDTO(repository.save(entity));
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }
}

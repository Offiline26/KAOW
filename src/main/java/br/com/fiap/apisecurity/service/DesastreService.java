package br.com.fiap.apisecurity.service;

import br.com.fiap.apisecurity.dto.DesastreDTO;
import br.com.fiap.apisecurity.mapper.DesastreMapper;
import br.com.fiap.apisecurity.model.Desastre;
import br.com.fiap.apisecurity.repository.DesastreRepository;
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

    public DesastreDTO findById(Long id) {
        return repository.findById(id)
                .map(DesastreMapper::toDTO)
                .orElse(null);
    }

    public DesastreDTO create(DesastreDTO dto) {
        Desastre entity = DesastreMapper.toEntity(dto);
        return DesastreMapper.toDTO(repository.save(entity));
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}

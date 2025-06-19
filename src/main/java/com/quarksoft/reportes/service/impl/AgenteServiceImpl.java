package com.quarksoft.reportes.service.impl;

import com.quarksoft.reportes.dto.AgenteDTO;
import com.quarksoft.reportes.entity.Agente;
import com.quarksoft.reportes.repository.AgenteRepository;
import com.quarksoft.reportes.service.AgenteService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AgenteServiceImpl implements AgenteService {
    private final AgenteRepository agenteRepository;

    @Override
    public List<AgenteDTO> findAll() {
        return agenteRepository.findAll().stream().map(this::toDTO).collect(Collectors.toList());
    }

    @Override
    public AgenteDTO findById(Integer id) {
        return agenteRepository.findById(id).map(this::toDTO).orElse(null);
    }

    @Override
    @Transactional
    public AgenteDTO create(AgenteDTO dto) {
        Agente agente = new Agente();
        BeanUtils.copyProperties(dto, agente);
        agente = agenteRepository.save(agente);
        return toDTO(agente);
    }

    @Override
    @Transactional
    public AgenteDTO update(Integer id, AgenteDTO dto) {
        Agente agente = agenteRepository.findById(id).orElseThrow();
        BeanUtils.copyProperties(dto, agente, "id");
        agente = agenteRepository.save(agente);
        return toDTO(agente);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        agenteRepository.deleteById(id);
    }

    private AgenteDTO toDTO(Agente agente) {
        AgenteDTO dto = new AgenteDTO();
        BeanUtils.copyProperties(agente, dto);
        return dto;
    }
}

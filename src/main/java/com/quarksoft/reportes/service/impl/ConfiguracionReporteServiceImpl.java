package com.quarksoft.reportes.service.impl;

import com.quarksoft.reportes.entity.ConfiguracionReporte;
import com.quarksoft.reportes.repository.ConfiguracionReporteRepository;
import com.quarksoft.reportes.service.ConfiguracionReporteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ConfiguracionReporteServiceImpl implements ConfiguracionReporteService {
    private final ConfiguracionReporteRepository repository;

    @Override
    public List<ConfiguracionReporte> findAll() {
        return repository.findAll();
    }

    @Override
    public ConfiguracionReporte findById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public ConfiguracionReporte create(ConfiguracionReporte config) {
        return repository.save(config);
    }

    @Override
    @Transactional
    public ConfiguracionReporte update(Integer id, ConfiguracionReporte config) {
        ConfiguracionReporte entity = repository.findById(id).orElseThrow();
        config.setId(id);
        return repository.save(config);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        repository.deleteById(id);
    }
}

package com.quarksoft.reportes.service;

import com.quarksoft.reportes.entity.ConfiguracionReporte;
import java.util.List;

public interface ConfiguracionReporteService {
    List<ConfiguracionReporte> findAll();
    ConfiguracionReporte findById(Integer id);
    ConfiguracionReporte create(ConfiguracionReporte config);
    ConfiguracionReporte update(Integer id, ConfiguracionReporte config);
    void delete(Integer id);
}

package com.quarksoft.reportes.repository;

import com.quarksoft.reportes.entity.ConfiguracionReporte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConfiguracionReporteRepository extends JpaRepository<ConfiguracionReporte, Integer> {
}

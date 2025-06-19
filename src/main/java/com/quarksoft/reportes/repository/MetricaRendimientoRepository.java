package com.quarksoft.reportes.repository;

import com.quarksoft.reportes.entity.MetricaRendimiento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MetricaRendimientoRepository extends JpaRepository<MetricaRendimiento, Integer> {
}

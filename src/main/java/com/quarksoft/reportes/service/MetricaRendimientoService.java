package com.quarksoft.reportes.service;

import com.quarksoft.reportes.entity.MetricaRendimiento;
import java.util.List;

public interface MetricaRendimientoService {
    List<MetricaRendimiento> findAll();
    MetricaRendimiento findById(Integer id);
    MetricaRendimiento create(MetricaRendimiento metrica);
    MetricaRendimiento update(Integer id, MetricaRendimiento metrica);
    void delete(Integer id);
}

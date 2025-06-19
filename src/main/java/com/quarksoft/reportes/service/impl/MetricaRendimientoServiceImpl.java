package com.quarksoft.reportes.service.impl;

import com.quarksoft.reportes.entity.MetricaRendimiento;
import com.quarksoft.reportes.repository.MetricaRendimientoRepository;
import com.quarksoft.reportes.service.MetricaRendimientoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MetricaRendimientoServiceImpl implements MetricaRendimientoService {
    private final MetricaRendimientoRepository repository;

    @Override
    public List<MetricaRendimiento> findAll() {
        return repository.findAll();
    }

    @Override
    public MetricaRendimiento findById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public MetricaRendimiento create(MetricaRendimiento metrica) {
        return repository.save(metrica);
    }

    @Override
    @Transactional
    public MetricaRendimiento update(Integer id, MetricaRendimiento metrica) {
        MetricaRendimiento entity = repository.findById(id).orElseThrow();
        metrica.setId(id);
        return repository.save(metrica);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        repository.deleteById(id);
    }
}

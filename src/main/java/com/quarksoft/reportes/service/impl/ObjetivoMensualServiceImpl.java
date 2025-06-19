package com.quarksoft.reportes.service.impl;

import com.quarksoft.reportes.entity.ObjetivoMensual;
import com.quarksoft.reportes.repository.ObjetivoMensualRepository;
import com.quarksoft.reportes.service.ObjetivoMensualService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ObjetivoMensualServiceImpl implements ObjetivoMensualService {
    private final ObjetivoMensualRepository repository;

    @Override
    public List<ObjetivoMensual> findAll() {
        return repository.findAll();
    }

    @Override
    public ObjetivoMensual findById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public ObjetivoMensual create(ObjetivoMensual objetivo) {
        return repository.save(objetivo);
    }

    @Override
    @Transactional
    public ObjetivoMensual update(Integer id, ObjetivoMensual objetivo) {
        ObjetivoMensual entity = repository.findById(id).orElseThrow();
        objetivo.setId(id);
        return repository.save(objetivo);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        repository.deleteById(id);
    }
}

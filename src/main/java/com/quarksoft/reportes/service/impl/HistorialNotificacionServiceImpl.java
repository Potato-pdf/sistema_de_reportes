package com.quarksoft.reportes.service.impl;

import com.quarksoft.reportes.entity.HistorialNotificacion;
import com.quarksoft.reportes.repository.HistorialNotificacionRepository;
import com.quarksoft.reportes.service.HistorialNotificacionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class HistorialNotificacionServiceImpl implements HistorialNotificacionService {
    private final HistorialNotificacionRepository repository;

    @Override
    public List<HistorialNotificacion> findAll() {
        return repository.findAll();
    }

    @Override
    public HistorialNotificacion findById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public HistorialNotificacion create(HistorialNotificacion notificacion) {
        return repository.save(notificacion);
    }

    @Override
    @Transactional
    public HistorialNotificacion update(Integer id, HistorialNotificacion notificacion) {
        HistorialNotificacion entity = repository.findById(id).orElseThrow();
        notificacion.setId(id);
        return repository.save(notificacion);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        repository.deleteById(id);
    }
}

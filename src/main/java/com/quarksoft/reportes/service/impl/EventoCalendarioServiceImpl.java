package com.quarksoft.reportes.service.impl;

import com.quarksoft.reportes.entity.EventoCalendario;
import com.quarksoft.reportes.repository.EventoCalendarioRepository;
import com.quarksoft.reportes.service.EventoCalendarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EventoCalendarioServiceImpl implements EventoCalendarioService {
    private final EventoCalendarioRepository repository;

    @Override
    public List<EventoCalendario> findAll() {
        return repository.findAll();
    }

    @Override
    public EventoCalendario findById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public EventoCalendario create(EventoCalendario evento) {
        return repository.save(evento);
    }

    @Override
    @Transactional
    public EventoCalendario update(Integer id, EventoCalendario evento) {
        EventoCalendario entity = repository.findById(id).orElseThrow();
        evento.setId(id);
        return repository.save(evento);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        repository.deleteById(id);
    }
}

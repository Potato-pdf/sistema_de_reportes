package com.quarksoft.reportes.service;

import com.quarksoft.reportes.entity.EventoCalendario;
import java.util.List;

public interface EventoCalendarioService {
    List<EventoCalendario> findAll();
    EventoCalendario findById(Integer id);
    EventoCalendario create(EventoCalendario evento);
    EventoCalendario update(Integer id, EventoCalendario evento);
    void delete(Integer id);
}

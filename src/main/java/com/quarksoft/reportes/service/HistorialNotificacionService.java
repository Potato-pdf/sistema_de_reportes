package com.quarksoft.reportes.service;

import com.quarksoft.reportes.entity.HistorialNotificacion;
import java.util.List;

public interface HistorialNotificacionService {
    List<HistorialNotificacion> findAll();
    HistorialNotificacion findById(Integer id);
    HistorialNotificacion create(HistorialNotificacion notificacion);
    HistorialNotificacion update(Integer id, HistorialNotificacion notificacion);
    void delete(Integer id);
}

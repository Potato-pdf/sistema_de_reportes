package com.quarksoft.reportes.service;

import com.quarksoft.reportes.entity.ObjetivoMensual;
import java.util.List;

public interface ObjetivoMensualService {
    List<ObjetivoMensual> findAll();
    ObjetivoMensual findById(Integer id);
    ObjetivoMensual create(ObjetivoMensual objetivo);
    ObjetivoMensual update(Integer id, ObjetivoMensual objetivo);
    void delete(Integer id);
}

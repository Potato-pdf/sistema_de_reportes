package com.quarksoft.reportes.repository;

import com.quarksoft.reportes.entity.HistorialNotificacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HistorialNotificacionRepository extends JpaRepository<HistorialNotificacion, Integer> {
}

package com.quarksoft.reportes.repository;

import com.quarksoft.reportes.entity.EventoCalendario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventoCalendarioRepository extends JpaRepository<EventoCalendario, Integer> {
}

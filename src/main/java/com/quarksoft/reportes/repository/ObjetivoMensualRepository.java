package com.quarksoft.reportes.repository;

import com.quarksoft.reportes.entity.ObjetivoMensual;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ObjetivoMensualRepository extends JpaRepository<ObjetivoMensual, Integer> {
}

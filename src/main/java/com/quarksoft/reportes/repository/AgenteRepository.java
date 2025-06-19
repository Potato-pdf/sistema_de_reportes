package com.quarksoft.reportes.repository;

import com.quarksoft.reportes.entity.Agente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgenteRepository extends JpaRepository<Agente, Integer> {
    // Métodos personalizados si se requieren
}

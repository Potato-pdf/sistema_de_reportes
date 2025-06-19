package com.quarksoft.reportes.repository;

import com.quarksoft.reportes.entity.AuditoriaSistema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuditoriaSistemaRepository extends JpaRepository<AuditoriaSistema, Integer> {
}

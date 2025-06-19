package com.quarksoft.reportes.service;

import com.quarksoft.reportes.entity.AuditoriaSistema;
import java.util.List;

public interface AuditoriaSistemaService {
    List<AuditoriaSistema> findAll();
    AuditoriaSistema findById(Integer id);
    AuditoriaSistema create(AuditoriaSistema auditoria);
    void delete(Integer id);
}

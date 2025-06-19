package com.quarksoft.reportes.service.impl;

import com.quarksoft.reportes.entity.AuditoriaSistema;
import com.quarksoft.reportes.repository.AuditoriaSistemaRepository;
import com.quarksoft.reportes.service.AuditoriaSistemaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AuditoriaSistemaServiceImpl implements AuditoriaSistemaService {
    private final AuditoriaSistemaRepository repository;

    @Override
    public List<AuditoriaSistema> findAll() {
        return repository.findAll();
    }

    @Override
    public AuditoriaSistema findById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public AuditoriaSistema create(AuditoriaSistema auditoria) {
        return repository.save(auditoria);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        repository.deleteById(id);
    }
}

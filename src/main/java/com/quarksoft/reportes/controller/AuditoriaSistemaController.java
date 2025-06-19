package com.quarksoft.reportes.controller;

import com.quarksoft.reportes.entity.AuditoriaSistema;
import com.quarksoft.reportes.service.AuditoriaSistemaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/auditoria")
@RequiredArgsConstructor
public class AuditoriaSistemaController {
    private final AuditoriaSistemaService service;

    @GetMapping
    public List<AuditoriaSistema> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AuditoriaSistema> getById(@PathVariable Integer id) {
        AuditoriaSistema entity = service.findById(id);
        return entity != null ? ResponseEntity.ok(entity) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<AuditoriaSistema> create(@RequestBody AuditoriaSistema auditoria) {
        return ResponseEntity.ok(service.create(auditoria));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}

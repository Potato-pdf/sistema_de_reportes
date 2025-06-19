package com.quarksoft.reportes.controller;

import com.quarksoft.reportes.entity.ObjetivoMensual;
import com.quarksoft.reportes.service.ObjetivoMensualService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/objetivos")
@RequiredArgsConstructor
public class ObjetivoMensualController {
    private final ObjetivoMensualService service;

    @GetMapping
    public List<ObjetivoMensual> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ObjetivoMensual> getById(@PathVariable Integer id) {
        ObjetivoMensual entity = service.findById(id);
        return entity != null ? ResponseEntity.ok(entity) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<ObjetivoMensual> create(@RequestBody ObjetivoMensual objetivo) {
        return ResponseEntity.ok(service.create(objetivo));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ObjetivoMensual> update(@PathVariable Integer id, @RequestBody ObjetivoMensual objetivo) {
        return ResponseEntity.ok(service.update(id, objetivo));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}

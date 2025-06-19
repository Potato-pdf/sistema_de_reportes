package com.quarksoft.reportes.controller;

import com.quarksoft.reportes.entity.HistorialNotificacion;
import com.quarksoft.reportes.service.HistorialNotificacionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/notificaciones")
@RequiredArgsConstructor
public class HistorialNotificacionController {
    private final HistorialNotificacionService service;

    @GetMapping
    public List<HistorialNotificacion> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<HistorialNotificacion> getById(@PathVariable Integer id) {
        HistorialNotificacion entity = service.findById(id);
        return entity != null ? ResponseEntity.ok(entity) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<HistorialNotificacion> create(@RequestBody HistorialNotificacion notificacion) {
        return ResponseEntity.ok(service.create(notificacion));
    }

    @PutMapping("/{id}")
    public ResponseEntity<HistorialNotificacion> update(@PathVariable Integer id, @RequestBody HistorialNotificacion notificacion) {
        return ResponseEntity.ok(service.update(id, notificacion));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}

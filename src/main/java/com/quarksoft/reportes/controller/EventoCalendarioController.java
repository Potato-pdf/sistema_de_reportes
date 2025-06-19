package com.quarksoft.reportes.controller;

import com.quarksoft.reportes.entity.EventoCalendario;
import com.quarksoft.reportes.service.EventoCalendarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/calendario")
@RequiredArgsConstructor
public class EventoCalendarioController {
    private final EventoCalendarioService service;

    @GetMapping
    public List<EventoCalendario> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<EventoCalendario> getById(@PathVariable Integer id) {
        EventoCalendario entity = service.findById(id);
        return entity != null ? ResponseEntity.ok(entity) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<EventoCalendario> create(@RequestBody EventoCalendario evento) {
        return ResponseEntity.ok(service.create(evento));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EventoCalendario> update(@PathVariable Integer id, @RequestBody EventoCalendario evento) {
        return ResponseEntity.ok(service.update(id, evento));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}

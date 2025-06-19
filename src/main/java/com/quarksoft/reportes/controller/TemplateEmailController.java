package com.quarksoft.reportes.controller;

import com.quarksoft.reportes.entity.TemplateEmail;
import com.quarksoft.reportes.service.TemplateEmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/templates-email")
@RequiredArgsConstructor
public class TemplateEmailController {
    private final TemplateEmailService service;

    @GetMapping
    public List<TemplateEmail> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TemplateEmail> getById(@PathVariable Integer id) {
        TemplateEmail entity = service.findById(id);
        return entity != null ? ResponseEntity.ok(entity) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<TemplateEmail> create(@RequestBody TemplateEmail template) {
        return ResponseEntity.ok(service.create(template));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TemplateEmail> update(@PathVariable Integer id, @RequestBody TemplateEmail template) {
        return ResponseEntity.ok(service.update(id, template));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}

package com.quarksoft.reportes.controller;

import com.quarksoft.reportes.dto.AgenteDTO;
import com.quarksoft.reportes.service.AgenteService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/agentes")
@RequiredArgsConstructor
public class AgenteController {
    private final AgenteService agenteService;

    @GetMapping
    public List<AgenteDTO> getAll() {
        return agenteService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AgenteDTO> getById(@PathVariable Integer id) {
        AgenteDTO dto = agenteService.findById(id);
        return dto != null ? ResponseEntity.ok(dto) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<AgenteDTO> create(@Valid @RequestBody AgenteDTO dto) {
        return ResponseEntity.ok(agenteService.create(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AgenteDTO> update(@PathVariable Integer id, @Valid @RequestBody AgenteDTO dto) {
        return ResponseEntity.ok(agenteService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        agenteService.delete(id);
        return ResponseEntity.noContent().build();
    }
}

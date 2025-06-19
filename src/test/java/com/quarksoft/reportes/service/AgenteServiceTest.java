package com.quarksoft.reportes.service;

import com.quarksoft.reportes.dto.AgenteDTO;
import com.quarksoft.reportes.entity.Agente;
import com.quarksoft.reportes.repository.AgenteRepository;
import com.quarksoft.reportes.service.impl.AgenteServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.Collections;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class AgenteServiceTest {
    @Mock
    private AgenteRepository agenteRepository;
    @InjectMocks
    private AgenteServiceImpl agenteService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testFindAll() {
        when(agenteRepository.findAll()).thenReturn(Collections.singletonList(new Agente()));
        assertFalse(agenteService.findAll().isEmpty());
    }

    @Test
    void testFindById() {
        Agente agente = new Agente();
        agente.setId(1);
        when(agenteRepository.findById(1)).thenReturn(Optional.of(agente));
        AgenteDTO dto = agenteService.findById(1);
        assertNotNull(dto);
        assertEquals(1, dto.getId());
    }

    @Test
    void testCreate() {
        Agente agente = new Agente();
        agente.setId(1);
        when(agenteRepository.save(any(Agente.class))).thenReturn(agente);
        AgenteDTO dto = new AgenteDTO();
        dto.setNombre("Test");
        AgenteDTO result = agenteService.create(dto);
        assertNotNull(result);
    }
}

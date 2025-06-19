package com.quarksoft.reportes.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.quarksoft.reportes.dto.AgenteDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class AgenteControllerIntegrationTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void testCreateAndGetAgente() throws Exception {
        AgenteDTO dto = new AgenteDTO();
        dto.setNombre("Juan");
        dto.setApellidoPaterno("Pérez");
        dto.setEmail("juan.perez@test.com");
        dto.setFechaContratacion(java.time.LocalDate.now());
        dto.setActivo(true);
        String json = objectMapper.writeValueAsString(dto);
        mockMvc.perform(post("/api/v1/agentes")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(status().isOk());
        mockMvc.perform(get("/api/v1/agentes"))
                .andExpect(status().isOk());
    }
}

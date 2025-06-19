package com.quarksoft.reportes.controller;

import com.quarksoft.reportes.integration.GmailIntegrationService;
import com.quarksoft.reportes.dto.AgenteDTO;
import com.quarksoft.reportes.service.AgenteService;
import jakarta.validation.Valid;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.util.Map;

@RestController
@RequestMapping("/api/reportes")
@RequiredArgsConstructor
public class ReporteController {
    private final TemplateEngine templateEngine;
    private final GmailIntegrationService gmailIntegrationService;
    private final AgenteService agenteService;

    @PostMapping("/enviar")
    public ResponseEntity<ReporteResponse> enviarReporte(@Valid @RequestBody ReporteRequest req) {
        // Si no se envían datos, obtenerlos automáticamente del agente
        Map<String, Object> datos = req.getDatos();
        if (datos == null || datos.isEmpty()) {
            AgenteDTO agente = agenteService.findById(req.getAgenteId());
            if (agente == null) {
                ReporteResponse error = new ReporteResponse();
                error.setStatus("ERROR");
                error.setMensaje("Agente no encontrado");
                return ResponseEntity.badRequest().body(error);
            }
            datos = new java.util.HashMap<>();
            datos.put("titulo", "Reporte de Desempeño de " + agente.getNombre() + " " + agente.getApellidoPaterno());
            datos.put("descripcion", "Reporte automático generado para el agente " + agente.getNombre() + " (ID: " + agente.getId() + ")");
            datos.put("nombre", agente.getNombre());
            datos.put("apellidoPaterno", agente.getApellidoPaterno());
            datos.put("apellidoMaterno", agente.getApellidoMaterno());
            datos.put("email", agente.getEmail());
            datos.put("telefono", agente.getTelefono());
            datos.put("territorio", agente.getTerritorio());
            datos.put("fechaContratacion", agente.getFechaContratacion());
            datos.put("fechaNacimiento", agente.getFechaNacimiento());
            datos.put("activo", agente.getActivo());
        }
        // 1. Generar el HTML del reporte usando Thymeleaf
        Context context = new Context();
        context.setVariables(datos);
        String html = templateEngine.process("reporte.html", context);

        // 2. Enviar el correo
        gmailIntegrationService.enviarCorreoAsync(
                req.getDestinatario(),
                "Reporte " + req.getTipo() + " (" + req.getFormato() + ")",
                html
        );

        // 3. Retornar respuesta
        ReporteResponse resp = new ReporteResponse();
        resp.setStatus("OK");
        resp.setMensaje("Reporte enviado exitosamente");
        return ResponseEntity.ok(resp);
    }

    @Data
    public static class ReporteRequest {
        private Integer agenteId;
        private String tipo;
        private String formato;
        private String destinatario;
        private Map<String, Object> datos;
    }

    @Data
    public static class ReporteResponse {
        private String status;
        private String mensaje;
    }
}

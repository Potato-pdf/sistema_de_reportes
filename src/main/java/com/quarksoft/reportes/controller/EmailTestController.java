package com.quarksoft.reportes.controller;


import com.quarksoft.reportes.integration.GmailIntegrationService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/email")
@RequiredArgsConstructor
public class EmailTestController {
    private final GmailIntegrationService gmailIntegrationService;

    @PostMapping("/test")
    public ResponseEntity<String> enviarCorreoTest(@RequestBody EmailTestRequest req) {
        gmailIntegrationService.enviarCorreoAsync(req.destinatario, req.asunto, req.cuerpoHtml);
        return ResponseEntity.ok("Correo enviado (si la configuración es correcta)");
    }

    @Data
    public static class EmailTestRequest {
        public String destinatario;
        public String asunto;
        public String cuerpoHtml;
    }
}

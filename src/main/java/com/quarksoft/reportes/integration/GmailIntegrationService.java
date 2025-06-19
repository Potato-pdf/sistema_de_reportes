package com.quarksoft.reportes.integration;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class GmailIntegrationService {
    @Async
    public void enviarCorreoAsync(String destinatario, String asunto, String cuerpo) {
        // Aquí iría la integración real con Gmail API usando OAuth2
        // Este es un placeholder para la lógica asíncrona de envío de correo
        System.out.println("Enviando correo a: " + destinatario + " | Asunto: " + asunto);
    }
}

package com.quarksoft.reportes.integration;

import com.quarksoft.reportes.service.EmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GmailIntegrationService {
    private final EmailService emailService;

    @Async
    public void enviarCorreoAsync(String destinatario, String asunto, String cuerpoHtml) {
        emailService.enviarCorreo(destinatario, asunto, cuerpoHtml);
    }
}

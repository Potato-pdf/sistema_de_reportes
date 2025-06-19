package com.quarksoft.reportes.service;

public interface EmailService {
    void enviarCorreo(String destinatario, String asunto, String cuerpoHtml);
}

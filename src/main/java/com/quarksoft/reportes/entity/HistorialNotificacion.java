package com.quarksoft.reportes.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "historial_notificaciones")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HistorialNotificacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "agente_id", nullable = false)
    private Agente agente;

    @Column(name = "tipo_notificacion", nullable = false, length = 50)
    private String tipoNotificacion;

    @Column(nullable = false, length = 200)
    private String asunto;

    @Column(columnDefinition = "text")
    private String contenido;

    @Column(name = "destinatario_email", nullable = false, length = 150)
    private String destinatarioEmail;

    @Column(name = "fecha_envio", nullable = false)
    private LocalDateTime fechaEnvio;

    @Column(name = "estado_entrega", nullable = false, length = 20)
    private String estadoEntrega;

    @Column(name = "numero_intentos")
    @Builder.Default
    private Integer numeroIntentos = 1;

    @Column(columnDefinition = "jsonb")
    private String metadata;

    @Column(name = "created_at", updatable = false)
    @Builder.Default
    private LocalDateTime createdAt = LocalDateTime.now();
}

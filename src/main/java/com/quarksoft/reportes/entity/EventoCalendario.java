package com.quarksoft.reportes.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "eventos_calendario")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EventoCalendario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "agente_id", nullable = false)
    private Agente agente;

    @Column(name = "google_event_id", length = 100, unique = true)
    private String googleEventId;

    @Column(nullable = false, length = 200)
    private String titulo;

    @Column(columnDefinition = "text")
    private String descripcion;

    @Column(name = "fecha_evento", nullable = false)
    private LocalDateTime fechaEvento;

    @Column(name = "tipo_evento", nullable = false, length = 50)
    private String tipoEvento;

    @Builder.Default
    @Column(name = "recordatorio_enviado")
    private Boolean recordatorioEnviado = false;

    @Builder.Default
    @Column(nullable = false)
    private Boolean activo = true;

    @Builder.Default
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt = LocalDateTime.now();
}

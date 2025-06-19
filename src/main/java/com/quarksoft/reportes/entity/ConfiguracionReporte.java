package com.quarksoft.reportes.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalTime;
import java.time.LocalDateTime;

@Entity
@Table(name = "configuraciones_reporte")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ConfiguracionReporte {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "agente_id", nullable = false)
    private Agente agente;

    @Column(name = "nombre_reporte", nullable = false, length = 100)
    private String nombreReporte;

    @Column(nullable = false, length = 20)
    private String frecuencia;

    @Column(nullable = false, length = 10)
    private String formato;

    @Column(name = "incluir_graficos")
    @Builder.Default
    private Boolean incluirGraficos = true;

    @Column(name = "campos_incluidos", columnDefinition = "jsonb")
    private String camposIncluidos;

    @Column(name = "hora_envio")
    @Builder.Default
    private LocalTime horaEnvio = LocalTime.of(8, 0);

    @Column(nullable = false)
    @Builder.Default
    private Boolean activo = true;

    @Column(name = "created_at", updatable = false)
    @Builder.Default
    private LocalDateTime createdAt = LocalDateTime.now();

    @Column(name = "updated_at")
    @Builder.Default
    private LocalDateTime updatedAt = LocalDateTime.now();
}

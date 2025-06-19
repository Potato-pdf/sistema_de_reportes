package com.quarksoft.reportes.entity;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "objetivos_mensuales")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ObjetivoMensual {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "agente_id", nullable = false)
    private Agente agente;

    @Column(name = "año", nullable = false)
    private Integer anio;

    @Column(nullable = false)
    private Integer mes;

    @Column(name = "objetivo_ventas", precision = 12, scale = 2, nullable = false)
    private BigDecimal objetivoVentas;

    @Column(name = "objetivo_clientes_nuevos", nullable = false)
    private Integer objetivoClientesNuevos;

    @Column(name = "objetivo_renovaciones", nullable = false)
    private Integer objetivoRenovaciones;

    @Builder.Default
    @Column(name = "bono_cumplimiento", precision = 10, scale = 2)
    private BigDecimal bonoCumplimiento = BigDecimal.ZERO;

    @Column(name = "fecha_limite", nullable = false)
    private LocalDate fechaLimite;

    @Builder.Default
    @Column(nullable = false)
    private Boolean cumplido = false;

    @Builder.Default
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    @Builder.Default
    @Column(name = "updated_at")
    private LocalDateTime updatedAt = LocalDateTime.now();
}

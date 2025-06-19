package com.quarksoft.reportes.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "metricas_rendimiento")
public class MetricaRendimiento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "agente_id", nullable = false)
    private Agente agente;

    @Column(nullable = false)
    private LocalDate fecha;

    @Column(name = "ventas_realizadas")
    private Integer ventasRealizadas = 0;

    @Column(name = "monto_ventas", precision = 12, scale = 2)
    private BigDecimal montoVentas = BigDecimal.ZERO;

    @Column(name = "clientes_nuevos")
    private Integer clientesNuevos = 0;

    @Column(name = "renovaciones")
    private Integer renovaciones = 0;

    @Column(name = "monto_renovaciones", precision = 12, scale = 2)
    private BigDecimal montoRenovaciones = BigDecimal.ZERO;

    @Column(name = "comision_ganada", precision = 10, scale = 2)
    private BigDecimal comisionGanada = BigDecimal.ZERO;

    @Column(name = "bono_adicional", precision = 10, scale = 2)
    private BigDecimal bonoAdicional = BigDecimal.ZERO;

    @Column(name = "tasa_retencion", precision = 5, scale = 2)
    private BigDecimal tasaRetencion = BigDecimal.ZERO;

    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    // Getters y setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    // ...
}

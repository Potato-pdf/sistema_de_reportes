package com.quarksoft.reportes.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "auditoria_sistema")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AuditoriaSistema {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "usuario_id")
    private Integer usuarioId;

    @Column(name = "tabla_afectada", nullable = false, length = 50)
    private String tablaAfectada;

    @Column(nullable = false, length = 20)
    private String operacion;

    @Column(name = "registro_id", nullable = false)
    private Integer registroId;

    @Column(name = "valores_anteriores", columnDefinition = "jsonb")
    private String valoresAnteriores;

    @Column(name = "valores_nuevos", columnDefinition = "jsonb")
    private String valoresNuevos;

    @Column(name = "ip_address")
    private String ipAddress;

    @Column(name = "user_agent", columnDefinition = "text")
    private String userAgent;

    @Builder.Default
    @Column(name = "timestamp")
    private LocalDateTime timestamp = LocalDateTime.now();
}

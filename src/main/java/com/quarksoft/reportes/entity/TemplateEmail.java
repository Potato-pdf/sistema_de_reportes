package com.quarksoft.reportes.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "templates_email")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TemplateEmail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 100, unique = true)
    private String nombre;

    @Column(nullable = false, length = 200)
    private String asunto;

    @Column(name = "contenido_html", columnDefinition = "text", nullable = false)
    private String contenidoHtml;

    @Column(name = "contenido_texto", columnDefinition = "text")
    private String contenidoTexto;

    @Column(name = "variables_disponibles", columnDefinition = "jsonb")
    private String variablesDisponibles;

    @Column(name = "tipo_template", nullable = false, length = 50)
    private String tipoTemplate;

    @Builder.Default
    @Column(nullable = false)
    private Boolean activo = true;

    @Builder.Default
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    @Builder.Default
    @Column(name = "updated_at")
    private LocalDateTime updatedAt = LocalDateTime.now();
}

package com.quarksoft.reportes.dto;

import lombok.Data;
import java.time.LocalDate;

@Data
public class AgenteDTO {
    private Integer id;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String email;
    private String telefono;
    private String territorio;
    private LocalDate fechaContratacion;
    private LocalDate fechaNacimiento;
    private Boolean activo;
}

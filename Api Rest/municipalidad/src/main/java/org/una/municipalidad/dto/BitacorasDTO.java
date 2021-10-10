package org.una.municipalidad.dto;

import lombok.*;
import org.una.municipalidad.entities.Usuarios;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class BitacorasDTO {
    private Long id;
    private String bitacoraTabla;
    private String bitacoraDescripcion;
    private String bitacoraUsuario;
    private Date bitacoraFecha;
    private Usuarios usuario;
}

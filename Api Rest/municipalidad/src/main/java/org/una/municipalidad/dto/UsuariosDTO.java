package org.una.municipalidad.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString


public class UsuariosDTO {
    private Long id;
    private String nombreUsuario;
    private boolean estado;
}

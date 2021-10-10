package org.una.municipalidad.dto;

import lombok.*;
import org.una.municipalidad.entities.Roles;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class UsuariosDTO {
    private Long id;
    private String nombreUsuario;
    private String claveEncriptado;
    private String cedula;
    private boolean estado;
    private RolesDTO roles;
}

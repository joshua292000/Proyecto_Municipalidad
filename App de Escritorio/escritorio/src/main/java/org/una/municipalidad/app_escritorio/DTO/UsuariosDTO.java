package org.una.municipalidad.app_escritorio.DTO;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class UsuariosDTO{
    private Long id;
    private String nombreUsuario;
    private String claveEncriptado;
    private String cedula;
    private boolean estado;
    private RolesDTO roles;
}

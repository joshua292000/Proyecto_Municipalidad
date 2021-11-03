package org.una.municipalidad.app_escritorio.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AuthenticationResponse {
    private String jwt;
    private UsuariosDTO usuarioDTO;
    private RolesDTO rolDTO;
}
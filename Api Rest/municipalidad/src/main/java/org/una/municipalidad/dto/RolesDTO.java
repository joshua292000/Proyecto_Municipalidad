package org.una.municipalidad.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class RolesDTO {
    private Long id;
    private String nombreRol;
    private String descripcionRol;
    private boolean estado;
}

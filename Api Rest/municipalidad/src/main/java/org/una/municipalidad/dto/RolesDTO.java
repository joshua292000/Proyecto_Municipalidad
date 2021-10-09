package org.una.municipalidad.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class RolesDTO {
    private Long id;
    private String nombreRol;
    private String descripcionRol;
    private boolean estado;
}

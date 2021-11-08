package org.una.municipalidad.app_escritorio.DTO;

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

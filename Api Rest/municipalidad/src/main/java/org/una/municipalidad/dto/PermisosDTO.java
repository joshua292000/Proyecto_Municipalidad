package org.una.municipalidad.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class PermisosDTO {
    private Long id;
    private String nombrePermiso;
    private String tipoPermiso;
    private String descripcionPermiso;
    private String categoriaPermiso;
}

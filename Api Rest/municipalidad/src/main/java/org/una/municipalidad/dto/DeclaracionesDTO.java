package org.una.municipalidad.dto;

import lombok.*;
import org.una.municipalidad.entities.Licencias_Comerciales;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder

public class DeclaracionesDTO {
    private Long id;
    private Long montoDeclarado;
    private Date annoDeclarado;
    private LicenciasComercialesDTO licenciacomercial;
}

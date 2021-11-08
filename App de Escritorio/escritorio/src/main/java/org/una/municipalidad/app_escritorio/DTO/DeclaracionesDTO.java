package org.una.municipalidad.app_escritorio.DTO;

import lombok.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder

public class DeclaracionesDTO {
    private Long id;
    private Long montoDeclarado;
    private Date fechaDeclarado;
    private LicenciasComercialesDTO licenciacomercial;
}

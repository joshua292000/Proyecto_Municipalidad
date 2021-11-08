package org.una.municipalidad.app_escritorio.DTO;

import lombok.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Contribuyentes_Licencias_ComercialesDTO {
    private Long porcentajeLicencia;
    private ContribuyentesDTO contribuyente;
    private Contribuyentes_Licencias_ComercialesDTO licenciacomercial;
}

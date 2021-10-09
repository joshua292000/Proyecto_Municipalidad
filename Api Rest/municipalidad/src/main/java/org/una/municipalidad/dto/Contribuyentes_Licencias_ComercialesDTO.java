package org.una.municipalidad.dto;

import lombok.*;
import org.una.municipalidad.entities.Contribuyentes;
import org.una.municipalidad.entities.Licencias_Comerciales;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Contribuyentes_Licencias_ComercialesDTO {
    private Long porcentajeLicencia;
    private Contribuyentes contribuyente;
    private Licencias_Comerciales licenciacomercial;
}

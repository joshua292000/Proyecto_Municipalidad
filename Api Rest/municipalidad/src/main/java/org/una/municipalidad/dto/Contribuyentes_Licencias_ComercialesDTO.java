package org.una.municipalidad.dto;

import org.una.municipalidad.entities.Contribuyentes;
import org.una.municipalidad.entities.Licencias_Comerciales;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Contribuyentes_Licencias_ComercialesDTO {
    private Long porcentajeLicencia;
    private Contribuyentes contribuyente;
    private Licencias_Comerciales licenciacomercial;
}

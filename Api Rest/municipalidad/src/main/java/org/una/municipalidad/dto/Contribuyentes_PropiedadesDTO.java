package org.una.municipalidad.dto;

import lombok.*;
import org.una.municipalidad.entities.Contribuyentes;
import org.una.municipalidad.entities.Propiedades;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Contribuyentes_PropiedadesDTO {
    private Long id;
    private Long porcentajePropiedad;
    private ContribuyentesDTO contribuyente;
    private PropiedadesDTO propiedades;
}

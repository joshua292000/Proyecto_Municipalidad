package org.una.municipalidad.app_escritorio.DTO;

import lombok.*;

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

package org.una.municipalidad.dto;

import lombok.*;
import org.una.municipalidad.entities.Contribuyentes;
import org.una.municipalidad.entities.Locales_Mercado;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Contribuyentes_Locales_MercadoDTO {
    private Long porcentajeLocales;
    private ContribuyentesDTO contribuyente;
    private Contribuyentes_Locales_MercadoDTO localesmercado;
}

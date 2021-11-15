package org.una.municipalidad.app_escritorio.DTO;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Contribuyentes_Locales_MercadoDTO {
    private Long id;
    private Double porcentajeLocales;
    private ContribuyentesDTO contribuyente;
    private LocalesMercadoDTO localesmercado;
}

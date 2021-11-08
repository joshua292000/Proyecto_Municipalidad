package org.una.municipalidad.app_escritorio.DTO;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class TipoCobrosDTO {
    private Long id;
    private String nombreTipoCobro;
}

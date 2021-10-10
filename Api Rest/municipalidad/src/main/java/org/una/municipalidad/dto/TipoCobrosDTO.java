package org.una.municipalidad.dto;

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

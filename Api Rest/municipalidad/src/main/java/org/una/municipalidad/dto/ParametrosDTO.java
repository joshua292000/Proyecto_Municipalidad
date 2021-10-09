package org.una.municipalidad.dto;

import lombok.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class ParametrosDTO {
    private Long id;
    private String parametrosLlaves;
    private String parametrosValor;
}

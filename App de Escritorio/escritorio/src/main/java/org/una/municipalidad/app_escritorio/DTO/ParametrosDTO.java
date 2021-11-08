package org.una.municipalidad.app_escritorio.DTO;

import lombok.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class ParametrosDTO {
    private Long id;
    private String llaveParametro;
    private String valorParametro;
}

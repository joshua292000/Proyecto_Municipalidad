package org.una.municipalidad.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class ContribuyentesDTO {
    private Long id;
    private String nombreContribuyente;
    private String apellidoContribuyente;
    private Long cedulaContribuyente;

}

package org.una.municipalidad.app_escritorio.DTO;

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
    private String cedulaContribuyente;

}

package org.una.municipalidad.app_escritorio.DTO;

import lombok.*;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder

public class LocalesMercadoDTO {
    private Long id;
    private String nombreLocal;
    private String ubicacionLocal;
    private String correoLocal;
    private Long telefonoLocal;
    private Long Monto_Alquiler_Local;
    private Date fechaRegistrolocal;
    private Date ultima_Actualizacionlocal;
    private String estado;
}

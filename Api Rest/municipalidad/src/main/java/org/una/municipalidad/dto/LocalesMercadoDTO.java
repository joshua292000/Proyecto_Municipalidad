package org.una.municipalidad.dto;

import lombok.*;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder

public class LocalesMercadoDTO {
    private Long id;
    private String nombreComercio;
    private String ubicacionLocal;
    private String correoComercio;
    private Long telefonoComercio;
    private Long Monto_Alquiler_Local;
    private Date fechaRegistrolocal;
    private Date ultima_Actualizacionlocal;
    private boolean estado;
}

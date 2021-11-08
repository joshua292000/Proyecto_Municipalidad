package org.una.municipalidad.app_escritorio.DTO;

import lombok.*;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class FacturasDTO {
    private Long id;
    private Date fechapago;
    private Long Monto_Total;
    private String medioDePago;
    private Long Monto_Pago;
    private Long Vuelto;
    private boolean estado;
}

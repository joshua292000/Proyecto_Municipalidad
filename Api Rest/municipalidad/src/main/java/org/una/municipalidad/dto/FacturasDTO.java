package org.una.municipalidad.dto;

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
    private String estado;
}

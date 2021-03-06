package org.una.municipalidad.app_escritorio.DTO;

import lombok.*;
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class CobroStringDTO {
    private String id;
    private String cobrosPeriodo;
    private String cobrosMonto;
    private String cobrosFechaCreacion;
    private String cobrosFechaVencimiento;
    private boolean Estado;
    private String cobrosFechaPago;
    private String licenciacomercial;
    private String facturas;
    private String tipocobros;
    private String localesmercado;
    private String propiedades;
}

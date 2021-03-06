package org.una.municipalidad.app_escritorio.DTO;

import lombok.*;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class CobrosDTO {
    private Long id;
    private String cobrosPeriodo;
    private Long cobrosMonto;
    private Date cobrosFechaCreacion;
    private Date cobrosFechaVencimiento;
    private String estado;
    private Date cobrosFechaPago;
    private LicenciasComercialesDTO licenciascomerciales;
    private FacturasDTO facturas;
    private TipoCobrosDTO tipocobros;
    private LocalesMercadoDTO localesmercado;
    private PropiedadesDTO propiedades;
}

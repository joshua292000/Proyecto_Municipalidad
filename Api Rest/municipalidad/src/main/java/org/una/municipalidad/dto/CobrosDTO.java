package org.una.municipalidad.dto;

import lombok.*;
import org.una.municipalidad.entities.*;

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
    private LicenciasComercialesDTO licenciacomercial;
    private FacturasDTO facturas;
    private TipoCobrosDTO tipocobros;
    private LocalesMercadoDTO localesmercado;
    private PropiedadesDTO propiedades;
}

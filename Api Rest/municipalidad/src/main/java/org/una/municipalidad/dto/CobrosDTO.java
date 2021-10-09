package org.una.municipalidad.dto;

import lombok.*;
import org.una.municipalidad.entities.Licencias_Comerciales;
import org.una.municipalidad.entities.Locales_Mercado;
import org.una.municipalidad.entities.Propiedades;

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
    private boolean Estado;
    private Date cobrosFechaPago;
    private Licencias_Comerciales licenciacomerciales;
    //private Facturas facturas;
    //private TipoCobros tcobros;
    private Locales_Mercado localescomerciales;
    private Propiedades propiedades;
}

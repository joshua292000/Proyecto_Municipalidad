package org.una.municipalidad.dto;

import lombok.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class PropiedadesDTO {
    private Long propiedades_id;
    private String propiedadProvincia;
    private String propiedadCanton;
    private String propiedadDistrito;
    private String propiedadDireccion;
    private Date propiedadGeolocalizacion;
    private Long propiedadArea;
    private Date propiedadPlano;
    private Long propiedadAMetrosFrente;
    private Long propiedadValorTerreno;
    private Long propiedadValorConstruccion;
    private Long propiedadOtrosValores;
    private boolean PerteneceEstado;
    private Date propiedadZona;
    private boolean Estado;
    private Date propiedad_fecha_Registro;
    private Date propiedad_ultima_Actualizacion;
}

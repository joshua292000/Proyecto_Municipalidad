package org.una.municipalidad.app_escritorio.DTO;

import javafx.beans.property.BooleanProperty;
import lombok.*;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder

public class LicenciasComercialesDTO {
    private Long id;
    private String nombreComercio;
    private Long telefonoComercio;
    private String correoComercio;
    private String distritoComercio;
    private Date fechaRegistrocomercio;
    private Date ultima_Actualizacioncomercio;
    private String codigoComercio;
    private String estado;


}

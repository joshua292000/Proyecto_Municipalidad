package org.una.municipalidad.entities;
import lombok.*;
import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "contribuyentes_licencias_comerciales")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class Contribuyentes_Licencias_Comerciales implements Serializable{

    @Column(name = "porcentaje_licencia")
    private Long porcentajeLicencia;

    @ManyToOne
    @JoinColumn(name="contribuyente_id")
    private Contribuyentes contribuyente;

    @ManyToOne
    @JoinColumn(name="licencia_id")
    private Licencias_Comerciales licenciacomercial;
}

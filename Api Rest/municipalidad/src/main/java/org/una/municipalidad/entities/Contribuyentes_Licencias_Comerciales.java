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
@Builder
public class Contribuyentes_Licencias_Comerciales implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "porcentaje_licencia")
    private Long porcentajeLicencia;

    @ManyToOne
    @JoinColumn(name="contribuyente_id")
    private Contribuyentes contribuyente;

    @ManyToOne
    @JoinColumn(name="licencia_id")
    private Licencias_Comerciales licenciacomercial;

    private static final long serialVersionUID = 1L;
}
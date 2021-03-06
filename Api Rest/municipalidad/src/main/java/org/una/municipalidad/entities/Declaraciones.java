package org.una.municipalidad.entities;

import lombok.*;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "declaraciones")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Declaraciones implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "monto_declarado")
    private Long montoDeclarado;

    @Column(name = "fecha_declarado", updatable = false)
    @Temporal(TemporalType.DATE)
    @Setter(AccessLevel.NONE)
    private Date fechaDeclarado;

    private static final long serialVersionUID = 1L;

    @ManyToOne
    @JoinColumn(name="licencia_id")
    private Licencias_Comerciales licenciacomercial;


}

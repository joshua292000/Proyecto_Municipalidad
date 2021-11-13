package org.una.municipalidad.entities;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Facturas")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Facturas implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "fecha_pago", updatable = false)
    @Temporal(TemporalType.DATE)
    @Setter(AccessLevel.NONE)
    private Date fechaPago;

    @Column(name = "Monto_Total")
    private Long Monto_Total;

    @Column(name = "medio_de_pago", length = 100)
    private String medioDePago;

    @Column(name = "Monto_Pago")
    private Long Monto_Pago;

    @Column(name = "Vuelto")
    private Long Vuelto;

    @Column(name = "estado", length = 100)
    private String estado;

    private static final long serialVersionUID = 1L;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "facturas")
    private List<Cobros> cobros = new ArrayList<>();

    @PrePersist
    public void prePersist() {
        fechaPago = new Date();

    }


}

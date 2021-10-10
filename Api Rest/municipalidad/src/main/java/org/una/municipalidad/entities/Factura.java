package org.una.municipalidad.entities;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "Contribuyentes")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Factura implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "fecha_pago", updatable = false)
    @Temporal(TemporalType.DATE)
    @Setter(AccessLevel.NONE)
    private Date fechapago;

    @Column(name = "Monto_Total")
    private Long Monto_Total;

    @Column(name = "medio_de_pago", length = 100)
    private String medioDePago;

    @Column(name = "Monto_Pago")
    private Long Monto_Pago;

    @Column(name = "Vuelto")
    private Long Vuelto;

    @Column
    private boolean estado;

    private static final long serialVersionUID = 1L;

    @PrePersist
    public void prePersist() {
        estado=true;
        fechapago = new Date();

    }


}

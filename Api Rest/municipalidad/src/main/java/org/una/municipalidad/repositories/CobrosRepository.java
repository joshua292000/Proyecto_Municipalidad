package org.una.municipalidad.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.una.municipalidad.entities.Cobros;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface CobrosRepository extends JpaRepository<Cobros, Long> {
    public Optional<Cobros> findByCobrosPeriodo(String cobrosPeriodo);
    public Optional<Cobros> findByCobrosMonto(Long cobrosMonto);

    public List<Cobros> findByEstado(String Estado);
    public int pagado = 0;

    @Query(value = "SELECT u FROM Cobros u LEFT JOIN u.licenciascomerciales e JOIN e.contribuyentes_licencias_comerciales c WHERE " +
            "c.contribuyente.cedulaContribuyente=:cedulaContribuyente AND u.estado = Pagado ")
    public List<Cobros> findCobrosByCedulaContribuyente(@Param("cedulaContribuyente") String cedulaContribuyente);

    @Query(value = "SELECT u FROM Cobros u LEFT JOIN u.licenciascomerciales e JOIN e.contribuyentes_licencias_comerciales c WHERE " +
            "  c.contribuyente.cedulaContribuyente=:cedulaContribuyente AND u.cobrosFechaCreacion >= :startDate AND u.cobrosFechaVencimiento <= :endDate AND u.estado = Pagado ")
    public List<Cobros> findByCobrosBetweenCedulaContribuyenteAndFecha(@Param("cedulaContribuyente")String cedulaContribuyente, @Param("startDate")Date startDate, @Param("endDate")Date endDate);

    @Query(value = "SELECT u FROM Cobros u LEFT JOIN u.licenciascomerciales e JOIN e.contribuyentes_licencias_comerciales c WHERE " +
            "c.contribuyente.cedulaContribuyente=:cedulaContribuyente AND u.estado = Pendiente ")
    public List<Cobros> findCobrosByCedulaContribuyentePendientes(@Param("cedulaContribuyente") String cedulaContribuyente);

    @Query(value = "SELECT u FROM Cobros u WHERE u.cobrosFechaCreacion >= :startDate AND u.cobrosFechaCreacion <= :endDate AND u.estado = 'Pendiente'")
    public List<Cobros> findByCobrosBetweenFechaPago(@Param("startDate")Date startDate, @Param("endDate")Date endDate);


}


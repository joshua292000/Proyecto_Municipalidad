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
    public List<Cobros> findByCobrosFechaPago(Date startDate, Date endDate);

   @Query(value = "SELECT u FROM Cobros u LEFT JOIN u.Contribuyentes_Lic_ComercialesService e WHERE e Contribuyentes.cedulaContribuyente=:cedulaContribuyente")
    public List<Cobros> findCobroByCedulaContribuyente(@Param("cedulaContribuyente") String cedulaContribuyente);


}

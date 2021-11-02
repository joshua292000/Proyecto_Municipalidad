package org.una.municipalidad.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.una.municipalidad.entities.Contribuyentes_Licencias_Comerciales;
import org.una.municipalidad.entities.Contribuyentes_Locales_Mercado;

import java.util.List;
import java.util.Optional;

@Repository
public interface Contribuyentes_Locales_MercadoRepository extends JpaRepository<Contribuyentes_Locales_Mercado, Long> {
    public Optional<Contribuyentes_Locales_Mercado> findByPorcentajeLocales(Long porcentajeLocales);
    @Query(value = "SELECT u FROM Contribuyentes_Locales_Mercado u WHERE " +
            "u.contribuyente.cedulaContribuyente=:cedulaContribuyente ")
    public List<Contribuyentes_Locales_Mercado> findContribuyentes_Locales_MercadoByCedula(@Param("cedulaContribuyente") String cedulaContribuyente);
}

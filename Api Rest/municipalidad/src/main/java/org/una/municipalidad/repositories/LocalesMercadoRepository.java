package org.una.municipalidad.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.una.municipalidad.entities.Licencias_Comerciales;
import org.una.municipalidad.entities.Locales_Mercado;

import java.util.List;
import java.util.Optional;

@Repository
public interface LocalesMercadoRepository extends JpaRepository<Locales_Mercado, Long> {
    public Optional<Locales_Mercado> findByNombreLocal(String nombreLocal);
    public List<Locales_Mercado> findByEstado(String Estado);
    @Query(value = "SELECT u FROM Locales_Mercado u LEFT JOIN u.contribuyentes_locales_mercados p JOIN p.contribuyente j WHERE " +
            "j.cedulaContribuyente=:cedulaContribuyente ")
    public List<Locales_Mercado> findLocales_MercadoByCedula(@Param("cedulaContribuyente") String cedulaContribuyente);

}

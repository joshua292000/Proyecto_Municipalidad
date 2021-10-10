package org.una.municipalidad.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.una.municipalidad.entities.Contribuyentes_Locales_Mercado;

import java.util.Optional;

public interface Contribuyentes_Locales_MercadoRepository extends JpaRepository<Contribuyentes_Locales_Mercado, Long> {
    public Optional<Contribuyentes_Locales_Mercado> findByPorcentajeLocales(Long porcentajeLocales);
}

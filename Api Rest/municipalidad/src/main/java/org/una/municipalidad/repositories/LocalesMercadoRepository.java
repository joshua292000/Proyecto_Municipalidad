package org.una.municipalidad.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.una.municipalidad.entities.Locales_Mercado;

import java.util.Optional;

public interface LocalesMercadoRepository extends JpaRepository<Locales_Mercado, Long> {
    public Optional<Locales_Mercado> findByNombreLocal(String nombreLocal);
}

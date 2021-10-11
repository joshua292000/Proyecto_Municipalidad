package org.una.municipalidad.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.una.municipalidad.entities.Locales_Mercado;

import java.util.Optional;

@Repository
public interface LocalesMercadoRepository extends JpaRepository<Locales_Mercado, Long> {
    public Optional<Locales_Mercado> findByNombreLocal(String nombreLocal);
}

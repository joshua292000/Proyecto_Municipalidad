package org.una.municipalidad.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.una.municipalidad.entities.Licencias_Comerciales;
import org.una.municipalidad.entities.Locales_Mercado;

import java.util.List;
import java.util.Optional;

@Repository
public interface LocalesMercadoRepository extends JpaRepository<Locales_Mercado, Long> {
    public Optional<Locales_Mercado> findByNombreLocal(String nombreLocal);
    public List<Locales_Mercado> findByEstado(String Estado);
}

package org.una.municipalidad.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.una.municipalidad.entities.Licencias_Comerciales;
import org.una.municipalidad.entities.Locales_Mercado;
import org.una.municipalidad.entities.Propiedades;

import java.util.List;
import java.util.Optional;

@Repository
public interface PropiedadesRepository extends JpaRepository<Propiedades, Long> {

    public Optional<Propiedades> findByPropiedadValorTerreno(long propiedadValorTerreno);
    public Optional<Propiedades> findByPropiedadValorConstruccion(long propiedadValorConstruccion);
    public List<Propiedades> findByEstado(String Estado);
}

package org.una.municipalidad.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.una.municipalidad.entities.Contribuyentes_Licencias_Comerciales;
import org.una.municipalidad.entities.Contribuyentes_Propiedades;

import java.util.List;
import java.util.Optional;

@Repository
public interface Contribuyentes_PropiedadesRepository extends JpaRepository<Contribuyentes_Propiedades, Long> {
    public Optional<Contribuyentes_Propiedades> findByPorcentajePropiedad(Long porcentajePropiedad);
    @Query(value = "SELECT u FROM Contribuyentes_Propiedades u WHERE " +
            "u.contribuyente.cedulaContribuyente=:cedulaContribuyente ")
    public List<Contribuyentes_Propiedades> findContribuyentes_PropiedadesByCedula(@Param("cedulaContribuyente") String cedulaContribuyente);
}

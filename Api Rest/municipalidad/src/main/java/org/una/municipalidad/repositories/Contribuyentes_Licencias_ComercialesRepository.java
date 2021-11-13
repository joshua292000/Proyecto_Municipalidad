package org.una.municipalidad.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.una.municipalidad.entities.Contribuyentes;
import org.una.municipalidad.entities.Contribuyentes_Licencias_Comerciales;

import java.util.List;
import java.util.Optional;

@Repository
public interface Contribuyentes_Licencias_ComercialesRepository extends JpaRepository<Contribuyentes_Licencias_Comerciales, Long>{

    public Optional<Contribuyentes_Licencias_Comerciales> findByPorcentajeLicencia(Long porcentajeLicencia);

    @Query(value = "SELECT u FROM Contribuyentes_Licencias_Comerciales u WHERE " +
            "u.contribuyente.cedulaContribuyente=:cedulaContribuyente ")
    public List<Contribuyentes_Licencias_Comerciales> findContribuyentes_Licencias_ComercialesByCedula(@Param("cedulaContribuyente") String cedulaContribuyente);
}

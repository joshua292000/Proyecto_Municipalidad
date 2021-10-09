package org.una.municipalidad.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.una.municipalidad.entities.Contribuyentes_Licencias_Comerciales;

import java.util.List;
import java.util.Optional;

@Repository
public interface Contribuyentes_Licencias_ComercialesRepository extends JpaRepository<Contribuyentes_Licencias_Comerciales, Long>{

    public Optional<Contribuyentes_Licencias_Comerciales> findByPorcentaje(Long porcentaje);

}

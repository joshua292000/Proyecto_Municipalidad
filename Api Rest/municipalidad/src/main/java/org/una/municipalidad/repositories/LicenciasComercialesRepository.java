package org.una.municipalidad.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.una.municipalidad.entities.Licencias_Comerciales;

import java.util.List;

@Repository
public interface LicenciasComercialesRepository extends JpaRepository<Licencias_Comerciales, Long> {

    public List<Licencias_Comerciales> findByCodigo(String codigoComercio);
    public List<Licencias_Comerciales> findByNombre(String nombreComercio);

}

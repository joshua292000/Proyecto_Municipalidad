package org.una.municipalidad.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.una.municipalidad.entities.Cobros;
import org.una.municipalidad.entities.Licencias_Comerciales;

import java.util.List;
import java.util.Optional;

@Repository
public interface LicenciasComercialesRepository extends JpaRepository<Licencias_Comerciales, Long> {

    public Optional<Licencias_Comerciales> findByCodigoComercio(String codigoComercio);
    public Optional<Licencias_Comerciales> findByNombreComercio(String nombreComercio);
    public List<Licencias_Comerciales> findByEstado(String Estado);

}

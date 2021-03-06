package org.una.municipalidad.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.una.municipalidad.entities.Contribuyentes_Licencias_Comerciales;
import org.una.municipalidad.entities.Licencias_Comerciales;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface LicenciasComercialesRepository extends JpaRepository<Licencias_Comerciales, Long> {

    public Optional<Licencias_Comerciales> findByCodigoComercio(String codigoComercio);
    public Optional<Licencias_Comerciales> findByNombreComercio(String nombreComercio);
    public List<Licencias_Comerciales> findByEstado(String Estado);
    @Query(value = "SELECT u FROM Licencias_Comerciales u LEFT JOIN u.contribuyentes_licencias_comerciales p JOIN p.contribuyente j WHERE " +
            "j.cedulaContribuyente=:cedulaContribuyente ")
    public List<Licencias_Comerciales> findLicencias_ComercialesByCedula(@Param("cedulaContribuyente") String cedulaContribuyente);

    @Query(value= "{CALL EliminarLicencia()}", nativeQuery = true)
    public void EliminarLicencia();
}

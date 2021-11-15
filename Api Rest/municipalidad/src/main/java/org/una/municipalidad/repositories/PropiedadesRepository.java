package org.una.municipalidad.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.una.municipalidad.entities.Licencias_Comerciales;
import org.una.municipalidad.entities.Propiedades;

import java.util.List;
import java.util.Optional;

@Repository
public interface PropiedadesRepository extends JpaRepository<Propiedades, Long> {

    public Optional<Propiedades> findByPropiedadValorTerreno(long propiedadValorTerreno);
    public Optional<Propiedades> findByPropiedadValorConstruccion(long propiedadValorConstruccion);
    public List<Propiedades> findByEstado(String Estado);
    @Query(value = "SELECT u FROM Propiedades u LEFT JOIN u.contribuyentes_propiedades p JOIN p.contribuyente j WHERE " +
            "j.cedulaContribuyente=:cedulaContribuyente ")
    public List<Propiedades> findPropiedadesByCedula(@Param("cedulaContribuyente") String cedulaContribuyente);

    @Query(value= "{CALL EliminarPropiedades()}", nativeQuery = true)
    public void EliminarPropiedades();
}

package org.una.municipalidad.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.una.municipalidad.entities.Declaraciones;

import java.util.Date;
import java.util.List;

@Repository
public interface DeclaracionesRepository extends JpaRepository<Declaraciones, Long>{

    public List<Declaraciones> findByMontoDeclarado(Long montoDeclarado);
    public List<Declaraciones> findByIdAndFechaDeclarado(Long id, Date fechaDeclarado);
    //public Declaraciones findDeclaracionByLicencia(Long id);

}

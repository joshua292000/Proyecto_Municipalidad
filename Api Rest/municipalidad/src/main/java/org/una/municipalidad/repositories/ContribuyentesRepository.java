package org.una.municipalidad.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.una.municipalidad.entities.Contribuyentes;
import java.util.Optional;


@Repository
public interface ContribuyentesRepository  extends JpaRepository<Contribuyentes, Long> {
    public Optional<Contribuyentes> findByNombre(String nombre);
    public Optional<Contribuyentes> findByCedula(Long cedula);

}

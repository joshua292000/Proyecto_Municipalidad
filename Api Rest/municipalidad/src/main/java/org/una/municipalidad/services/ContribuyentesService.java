package org.una.municipalidad.services;

import org.springframework.data.repository.query.Param;
import org.una.municipalidad.dto.ContribuyentesDTO;
import org.una.municipalidad.entities.Contribuyentes;

import java.util.List;
import java.util.Optional;

public interface ContribuyentesService {

    public Optional<ContribuyentesDTO> findById(Long id);
    public Optional<ContribuyentesDTO> findByNombreContribuyente(String nombreContribuyente);
    public Optional<ContribuyentesDTO> findByCedulaContribuyente(String cedulaContribuyente);
    public Optional<ContribuyentesDTO> create(ContribuyentesDTO contribuyentesDTO);
    public Optional<ContribuyentesDTO> update(ContribuyentesDTO contribuyentesDTO);

}

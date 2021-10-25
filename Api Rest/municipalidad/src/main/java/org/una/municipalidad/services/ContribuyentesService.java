package org.una.municipalidad.services;

import org.una.municipalidad.dto.ContribuyentesDTO;

import java.util.Optional;

public interface ContribuyentesService {

    public Optional<ContribuyentesDTO> findById(Long id);
    public Optional<ContribuyentesDTO> findByNombreContribuyente(String nombreContribuyente);
    public Optional<ContribuyentesDTO> findByCedulaContribuyente(String cedulaContribuyente);
    public Optional<ContribuyentesDTO> create(ContribuyentesDTO contribuyentesDTO);
    public Optional<ContribuyentesDTO> update(ContribuyentesDTO contribuyentesDTO);

}

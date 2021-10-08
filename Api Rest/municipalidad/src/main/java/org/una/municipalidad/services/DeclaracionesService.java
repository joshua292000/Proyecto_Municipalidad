package org.una.municipalidad.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.una.municipalidad.dto.DeclaracionesDTO;

public interface DeclaracionesService {
    public Optional<List<DeclaracionesDTO>> findAll();

    public Optional<DeclaracionesDTO> findById(Long id);

    public Optional<List<DeclaracionesDTO>> findByMonto(Long montoDeclarado);

    public Optional<List<DeclaracionesDTO>> findByAnnoDeclaracion(Date annoDeclarado);

    public Optional<DeclaracionesDTO> create(DeclaracionesDTO declaracionesDTO);

    public Optional<DeclaracionesDTO> update(DeclaracionesDTO declaracionesDTO, Long id);

    public void delete(Long id);

    public void deleteAll();
}

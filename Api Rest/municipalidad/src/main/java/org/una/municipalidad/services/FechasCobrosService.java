package org.una.municipalidad.services;

import org.springframework.data.repository.query.Param;
import org.una.municipalidad.dto.CobrosDTO;
import org.una.municipalidad.dto.FechasCobrosDTO;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface FechasCobrosService {

    public Optional<List<FechasCobrosDTO>> findAll();

    public Optional<FechasCobrosDTO> create(FechasCobrosDTO fechasCobrosDTO);

    public Optional<FechasCobrosDTO> update(FechasCobrosDTO fechasCobrosDTO, Long id);
}

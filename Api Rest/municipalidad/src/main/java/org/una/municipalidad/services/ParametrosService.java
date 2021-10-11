package org.una.municipalidad.services;

import org.una.municipalidad.dto.ParametrosDTO;

import java.util.List;
import java.util.Optional;

public interface ParametrosService {
    public Optional<List<ParametrosDTO>> findAll();

    public Optional<ParametrosDTO> findById(Long id);

    public Optional<ParametrosDTO> findByLlaveParametro(String llaveParametro);

    public Optional<ParametrosDTO> findByValorParametro(String valorParametro);

    public Optional<ParametrosDTO> create(ParametrosDTO parametrosDTO);

    public Optional<ParametrosDTO> update(ParametrosDTO parametrosDTO, Long id);

    public void delete(Long id);

    public void deleteAll();
}

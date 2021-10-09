package org.una.municipalidad.services;


import org.una.municipalidad.dto.CobrosDTO;

import java.util.List;
import java.util.Optional;

public interface CobrosService {
    public Optional<List<CobrosDTO>> findAll();

    public Optional<CobrosDTO> findById(Long id);

    public Optional<CobrosDTO> findByCobrosPeriodo(String cobrosPeriodo);

    public Optional<CobrosDTO> findByCobrosMonto(Long cobrosMonto);

    public Optional<CobrosDTO> create(CobrosDTO cobrosDTO);

    public Optional<CobrosDTO> update(CobrosDTO cobrosDTO, Long id);

    public void delete(Long id);

    public void deleteAll();
}

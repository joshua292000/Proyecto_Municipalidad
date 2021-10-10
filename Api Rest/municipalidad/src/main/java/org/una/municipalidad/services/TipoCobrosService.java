package org.una.municipalidad.services;

import org.una.municipalidad.dto.TipoCobrosDTO;

import java.util.Optional;

public interface TipoCobrosService {

    public Optional<TipoCobrosDTO> findByNombreTipoCobro(String nombreTipoCobro);
    public Optional<TipoCobrosDTO> create(TipoCobrosDTO tipoCobrosDTO);
    public Optional<TipoCobrosDTO> update(TipoCobrosDTO tipoCobrosDTO);
}

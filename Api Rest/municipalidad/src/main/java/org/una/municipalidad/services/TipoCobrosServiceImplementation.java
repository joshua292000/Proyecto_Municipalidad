package org.una.municipalidad.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.una.municipalidad.dto.ContribuyentesDTO;
import org.una.municipalidad.dto.FacturasDTO;
import org.una.municipalidad.dto.TipoCobrosDTO;
import org.una.municipalidad.entities.Contribuyentes;
import org.una.municipalidad.entities.Facturas;
import org.una.municipalidad.entities.TipoCobros;
import org.una.municipalidad.exceptions.NotFoundInformationException;
import org.una.municipalidad.repositories.TipoCobrosRepository;
import org.una.municipalidad.utils.MapperUtils;

import java.util.Optional;

public class TipoCobrosServiceImplementation implements TipoCobrosService{
    @Autowired
    private TipoCobrosRepository tipoCobrosRepository;

    @Override
    @Transactional(readOnly = true)s
    public Optional<TipoCobrosDTO> findById(Long id) {
        Optional<TipoCobros> tipoCobros = tipoCobrosRepository.findById(id);
        if (tipoCobros.isEmpty()) throw new NotFoundInformationException();

        TipoCobrosDTO tipoCobrosDTO = MapperUtils.DtoFromEntity(tipoCobros.get(), TipoCobrosDTO.class);
        return Optional.ofNullable(tipoCobrosDTO);

    }

    @Override
    public Optional<TipoCobrosDTO> findByNombreTipoCobro(String nombreTipoCobro) {
        Optional<TipoCobros> tipoCobros = tipoCobrosRepository.findByNombreTipoCobro(nombreTipoCobro)  ;
        return Optional.ofNullable(MapperUtils.DtoFromEntity(tipoCobros, TipoCobrosDTO.class));
    }

    @Override
    public Optional<TipoCobrosDTO> create(TipoCobrosDTO tipoCobrosDTO) {
        return Optional.ofNullable(getSavedTipoCobrosDTO(tipoCobrosDTO));
    }

    @Override
    public Optional<TipoCobrosDTO> update(TipoCobrosDTO tipoCobrosDTO) {
        return Optional.ofNullable(getSavedTipoCobrosDTO(tipoCobrosDTO));
    }

    private TipoCobrosDTO getSavedTipoCobrosDTO(TipoCobrosDTO tipoCobrosDTO) {
        TipoCobros tipoCobros = MapperUtils.EntityFromDto(tipoCobrosDTO, TipoCobros.class);
        TipoCobros tipoCobrosCreated = tipoCobrosRepository.save(tipoCobros);
        return MapperUtils.DtoFromEntity(tipoCobrosCreated, TipoCobrosDTO.class);
    }
}

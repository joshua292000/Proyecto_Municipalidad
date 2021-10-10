package org.una.municipalidad.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.una.municipalidad.dto.ContribuyentesDTO;
import org.una.municipalidad.dto.FacturasDTO;
import org.una.municipalidad.entities.Contribuyentes;
import org.una.municipalidad.entities.Facturas;
import org.una.municipalidad.exceptions.NotFoundInformationException;
import org.una.municipalidad.repositories.FacturasRepository;
import org.una.municipalidad.utils.MapperUtils;

import java.util.Date;
import java.util.Optional;

public class FacturasServiceImplementation implements FacturasService{
    @Autowired
    private FacturasRepository facturasRepository;

    @Override
    @Transactional(readOnly = true)
    public Optional<FacturasDTO> findById(Long id) {
        Optional<Facturas> facturas = facturasRepository.findById(id);
        if (facturas.isEmpty()) throw new NotFoundInformationException();

        FacturasDTO facturasDTO = MapperUtils.DtoFromEntity(facturas.get(), FacturasDTO.class);
        return Optional.ofNullable(facturasDTO);

    }

    @Override
    public Optional<FacturasDTO> findByFechaPago(Date fechapago) {
        Optional<Facturas> facturas = facturasRepository.findByFechaPago(fechapago) ;
        return Optional.ofNullable(MapperUtils.DtoFromEntity(facturas, FacturasDTO.class));
    }

    @Override
    public Optional<FacturasDTO> create(FacturasDTO facturasDTO) {
        return Optional.ofNullable(getSavedFacturasDTO(facturasDTO));
    }

    @Override
    public Optional<FacturasDTO> update(FacturasDTO facturasDTO) {
        return Optional.ofNullable(getSavedFacturasDTO(facturasDTO));
    }

    private FacturasDTO getSavedFacturasDTO(FacturasDTO facturasDTO) {
        Facturas facturas = MapperUtils.EntityFromDto(facturasDTO, Facturas.class);
        Facturas facturasCreated = facturasRepository.save(facturas);
        return MapperUtils.DtoFromEntity(facturasCreated, FacturasDTO.class);
    }
}

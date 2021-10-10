package org.una.municipalidad.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.una.municipalidad.dto.ContribuyentesDTO;
import org.una.municipalidad.dto.FacturasDTO;
import org.una.municipalidad.dto.LocalesMercadoDTO;
import org.una.municipalidad.entities.Contribuyentes;
import org.una.municipalidad.entities.Facturas;
import org.una.municipalidad.entities.Locales_Mercado;
import org.una.municipalidad.exceptions.NotFoundInformationException;
import org.una.municipalidad.repositories.LocalesMercadoRepository;
import org.una.municipalidad.utils.MapperUtils;

import java.util.Optional;

@Service
public class LocalesMercadoServiceImplementation implements LocalesMercadoService {
    @Autowired
    private LocalesMercadoRepository localesMercadoRepository;

    @Override
    @Transactional(readOnly = true)
    public Optional<LocalesMercadoDTO> findById(Long id) {
        Optional<Locales_Mercado> locales_mercado = localesMercadoRepository.findById(id);
        if (locales_mercado.isEmpty()) throw new NotFoundInformationException();

        LocalesMercadoDTO locales_mercadoDTO = MapperUtils.DtoFromEntity(locales_mercado.get(), LocalesMercadoDTO.class);
        return Optional.ofNullable(locales_mercadoDTO);

    }

    @Override
    public Optional<LocalesMercadoDTO> findByNombreLocal(String nombreLocal) {
        Optional<Locales_Mercado> locales_mercado = localesMercadoRepository.findByNombreLocal(nombreLocal);
        return Optional.ofNullable(MapperUtils.DtoFromEntity(locales_mercado, LocalesMercadoDTO.class));
    }

    @Override
    public Optional<LocalesMercadoDTO> create(LocalesMercadoDTO localesMercadoDTO) {
        return Optional.ofNullable(getSavedLocalesMercadoDTO(localesMercadoDTO));
    }

    @Override
    public Optional<LocalesMercadoDTO> update(LocalesMercadoDTO localesMercadoDTO) {
        return Optional.ofNullable(getSavedLocalesMercadoDTO(localesMercadoDTO));
    }

    private LocalesMercadoDTO getSavedLocalesMercadoDTO(LocalesMercadoDTO localesMercadoDTO) {
        Locales_Mercado locales_mercado = MapperUtils.EntityFromDto(localesMercadoDTO, Locales_Mercado.class);
        Locales_Mercado locales_mercadoCreated = localesMercadoRepository.save(locales_mercado );
        return MapperUtils.DtoFromEntity(locales_mercadoCreated, LocalesMercadoDTO.class);
    }
}

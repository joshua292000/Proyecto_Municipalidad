package org.una.municipalidad.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.una.municipalidad.dto.ContribuyentesDTO;
import org.una.municipalidad.dto.LocalesMercadoDTO;
import org.una.municipalidad.entities.Contribuyentes;
import org.una.municipalidad.entities.Locales_Mercado;
import org.una.municipalidad.repositories.LocalesMercadoRepository;
import org.una.municipalidad.utils.MapperUtils;

import java.util.Optional;

public class LocalesMercadoServiceImplementation implements LocalesMercadoService {
    @Autowired
    private LocalesMercadoRepository localesMercadoRepository;

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

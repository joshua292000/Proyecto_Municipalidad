package org.una.municipalidad.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.una.municipalidad.dto.ContribuyentesDTO;
import org.una.municipalidad.dto.FacturasDTO;
import org.una.municipalidad.dto.LicenciasComercialesDTO;
import org.una.municipalidad.dto.LocalesMercadoDTO;
import org.una.municipalidad.entities.Contribuyentes;
import org.una.municipalidad.entities.Facturas;
import org.una.municipalidad.entities.Licencias_Comerciales;
import org.una.municipalidad.entities.Locales_Mercado;
import org.una.municipalidad.exceptions.NotFoundInformationException;
import org.una.municipalidad.repositories.LocalesMercadoRepository;
import org.una.municipalidad.utils.MapperUtils;

import java.util.List;
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
    @Transactional(readOnly = true)
    public Optional<List<LocalesMercadoDTO>> findAll() {
        List<LocalesMercadoDTO> localesmercadoDTOList = MapperUtils.DtoListFromEntityList(localesMercadoRepository.findAll(), LocalesMercadoDTO.class);
        if (localesmercadoDTOList.isEmpty()) throw new NotFoundInformationException();
        return Optional.ofNullable(localesmercadoDTOList);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<LocalesMercadoDTO> findByNombreLocal(String nombreLocal) {
        Optional<Locales_Mercado> locales_mercado = localesMercadoRepository.findByNombreLocal(nombreLocal);
        if(locales_mercado.isEmpty()) throw new NotFoundInformationException();
        LocalesMercadoDTO localesMercadoDTO = MapperUtils.DtoFromEntity(locales_mercado.get(),LocalesMercadoDTO.class);
        return Optional.ofNullable(localesMercadoDTO);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<List<LocalesMercadoDTO>> findByEstado(String Estado) {
        List<Locales_Mercado> Cobroslist = localesMercadoRepository.findByEstado(Estado);
        List<LocalesMercadoDTO> CobrosDtolist = MapperUtils.DtoListFromEntityList(Cobroslist,LocalesMercadoDTO.class);
        return Optional.ofNullable(CobrosDtolist);
    }

    @Override
    @Transactional(readOnly = true)
    public void EliminarLocales() {
        localesMercadoRepository.EliminarLocales();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<List<LocalesMercadoDTO>> findLocales_MercadoByCedula(String cedulaContribuyente) {
        List<Locales_Mercado> contribuyenteslist = localesMercadoRepository.findLocales_MercadoByCedula(cedulaContribuyente);
        List<LocalesMercadoDTO> contribuyentesDTO = MapperUtils.DtoListFromEntityList(contribuyenteslist,LocalesMercadoDTO.class);
        return Optional.ofNullable(contribuyentesDTO);
    }

    private LocalesMercadoDTO getSavedLocalesMercadoDTO(LocalesMercadoDTO localesMercadoDTO) {
        Locales_Mercado locales_mercado = MapperUtils.EntityFromDto(localesMercadoDTO, Locales_Mercado.class);
        Locales_Mercado locales_mercadoCreated = localesMercadoRepository.save(locales_mercado );
        return MapperUtils.DtoFromEntity(locales_mercadoCreated, LocalesMercadoDTO.class);
    }

    @Override
    public Optional<LocalesMercadoDTO> create(LocalesMercadoDTO localesMercadoDTO) {
        return Optional.ofNullable(getSavedLocalesMercadoDTO(localesMercadoDTO));
    }

    @Override
    public Optional<LocalesMercadoDTO> update(LocalesMercadoDTO localesMercadoDTO, Long id) {
        if (localesMercadoRepository.findById(id).isEmpty()) throw new NotFoundInformationException();
        return Optional.ofNullable(getSavedLocalesMercadoDTO(localesMercadoDTO));
    }


}

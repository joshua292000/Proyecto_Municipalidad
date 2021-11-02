package org.una.municipalidad.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.una.municipalidad.dto.Contribuyentes_Licencias_ComercialesDTO;
import org.una.municipalidad.dto.Contribuyentes_Locales_MercadoDTO;
import org.una.municipalidad.entities.Contribuyentes_Licencias_Comerciales;
import org.una.municipalidad.entities.Contribuyentes_Locales_Mercado;
import org.una.municipalidad.repositories.Contribuyentes_Locales_MercadoRepository;
import org.una.municipalidad.utils.MapperUtils;

import java.util.List;
import java.util.Optional;
@Service
public class Contribuyentes_Loc_MercadoServiceImplementation implements Contribuyentes_Loc_MercadoService{

    @Autowired
    private Contribuyentes_Locales_MercadoRepository contribuyentes_locales_mercadoRepository;

    @Override
    @Transactional(readOnly = true)
    public Optional<Contribuyentes_Locales_MercadoDTO> findByPorcentajeLocales(Long porcentajeLocales) {
        Optional<Contribuyentes_Locales_Mercado> contriLocMerc = contribuyentes_locales_mercadoRepository.findByPorcentajeLocales(porcentajeLocales);
        return Optional.ofNullable(MapperUtils.DtoFromEntity(contriLocMerc, Contribuyentes_Locales_MercadoDTO.class));
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<List<Contribuyentes_Locales_MercadoDTO>> findContribuyentes_Locales_MercadoByCedula(String cedulaContribuyente) {
        List<Contribuyentes_Locales_Mercado> contribuyenteslist = contribuyentes_locales_mercadoRepository.findContribuyentes_Locales_MercadoByCedula(cedulaContribuyente);
        List<Contribuyentes_Locales_MercadoDTO> contribuyentesDTO = MapperUtils.DtoListFromEntityList(contribuyenteslist,Contribuyentes_Locales_MercadoDTO.class);
        return Optional.ofNullable(contribuyentesDTO);
    }

    @Override
    public Optional<Contribuyentes_Locales_MercadoDTO> create(Contribuyentes_Locales_MercadoDTO contriLocMercDTO) {
        return Optional.ofNullable(getSavedContribuyentes_Locales_MercadoDTO(contriLocMercDTO));
    }

    @Override
    public Optional<Contribuyentes_Locales_MercadoDTO> update(Contribuyentes_Locales_MercadoDTO contriLocMercDTO) {
        return Optional.ofNullable(getSavedContribuyentes_Locales_MercadoDTO(contriLocMercDTO));
    }

    @Override
    public void deleteAll() {
    contribuyentes_locales_mercadoRepository.deleteAll();
    }

    private Contribuyentes_Locales_MercadoDTO getSavedContribuyentes_Locales_MercadoDTO(Contribuyentes_Locales_MercadoDTO contriLocMercDTO) {
        Contribuyentes_Locales_Mercado contriLocMerc = MapperUtils.EntityFromDto(contriLocMercDTO, Contribuyentes_Locales_Mercado.class);
        Contribuyentes_Locales_Mercado contriLocMercCreated = contribuyentes_locales_mercadoRepository.save(contriLocMerc);
        return MapperUtils.DtoFromEntity(contriLocMercCreated, Contribuyentes_Locales_MercadoDTO.class);
    }
}

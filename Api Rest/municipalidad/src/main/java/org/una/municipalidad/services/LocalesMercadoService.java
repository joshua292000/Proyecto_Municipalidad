package org.una.municipalidad.services;


import org.springframework.data.repository.query.Param;
import org.una.municipalidad.dto.LicenciasComercialesDTO;
import org.una.municipalidad.dto.LocalesMercadoDTO;


import java.util.List;
import java.util.Optional;

public interface LocalesMercadoService {
    public Optional<LocalesMercadoDTO> findById(Long id);
    public Optional<LocalesMercadoDTO> findByNombreLocal(String nombreLocal);
    public Optional<List<LocalesMercadoDTO>> findByEstado(String Estado);
    public Optional<List<LocalesMercadoDTO>> findLocales_MercadoByCedula(@Param("cedulaContribuyente") String cedulaContribuyente);
    public Optional<LocalesMercadoDTO> create(LocalesMercadoDTO localesMercadoDTO);
    public Optional<LocalesMercadoDTO> update(LocalesMercadoDTO localesMercadoDTO, Long id);
}

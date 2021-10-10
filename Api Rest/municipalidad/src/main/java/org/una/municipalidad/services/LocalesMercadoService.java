package org.una.municipalidad.services;


import org.una.municipalidad.dto.LocalesMercadoDTO;


import java.util.Optional;

public interface LocalesMercadoService {
    public Optional<LocalesMercadoDTO> findByNombreLocal(String nombreLocal);
    public Optional<LocalesMercadoDTO> create(LocalesMercadoDTO localesMercadoDTO);
    public Optional<LocalesMercadoDTO> update(LocalesMercadoDTO localesMercadoDTO);
}

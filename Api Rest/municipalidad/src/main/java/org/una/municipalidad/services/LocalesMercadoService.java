package org.una.municipalidad.services;


import org.una.municipalidad.dto.LocalesMercadoDTO;
import org.una.municipalidad.entities.Locales_Mercado;


import java.util.List;
import java.util.Optional;

public interface LocalesMercadoService {
    public Optional<LocalesMercadoDTO> findById(Long id);
    public Optional<LocalesMercadoDTO> findByNombreLocal(String nombreLocal);
    public Optional<List<LocalesMercadoDTO>> findByEstado(String Estado);
    public Optional<LocalesMercadoDTO> create(LocalesMercadoDTO localesMercadoDTO);
    public Optional<LocalesMercadoDTO> update(LocalesMercadoDTO localesMercadoDTO);
}

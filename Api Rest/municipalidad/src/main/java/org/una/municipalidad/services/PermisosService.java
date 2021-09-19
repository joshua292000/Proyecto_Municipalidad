package org.una.municipalidad.services;

import org.una.municipalidad.dto.PermisosDTO;


import java.util.List;
import java.util.Optional;

public interface PermisosService {
    public Optional<List<PermisosDTO>> findAll();

    public Optional<PermisosDTO> findById(Long id);

    public Optional<List<PermisosDTO>> findByNombrePermisoAproximateIgnoreCase(String nombrePermiso);

    public Optional<List<PermisosDTO>> findByNombrePermisoAproximate(String nombrePermiso);

    public Optional<PermisosDTO> create(PermisosDTO permisosDTO);

    public Optional<PermisosDTO> update(PermisosDTO permisosDTO, Long id);

    public void delete(Long id);

    public void deleteAll();

    //public Optional<PermisosDTO> login(String nombreUsuario,String claveEncriptado);
}

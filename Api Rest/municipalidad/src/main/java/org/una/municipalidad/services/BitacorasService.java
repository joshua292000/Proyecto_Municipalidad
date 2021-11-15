package org.una.municipalidad.services;


import org.springframework.data.repository.query.Param;
import org.una.municipalidad.dto.BitacorasDTO;
import org.una.municipalidad.entities.BitacoraCambios;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface BitacorasService {
    public Optional<List<BitacorasDTO>> findAll();

    public Optional<BitacorasDTO> findById(Long id);

    public Optional<BitacorasDTO> findByBitacoraTabla(String bitacoraTabla);

    public Optional<BitacorasDTO> findByBitacoraDescripcion(String bitacoraDescripcion);

    public Optional<List<BitacorasDTO>> findByIdBetweenFecha(@Param("idUsuario")Long id, @Param("startDate") Date startDate,
                                                                @Param("endDate")Date endDate);
    public Optional<List<BitacorasDTO>>findByBitacoraCambiosBetweenFecha(@Param("startDate")Date startDate, @Param("endDate")Date endDate);

    public Optional<BitacorasDTO> findByIdUsuario(@Param("idUsuario")Long id);

    public Optional<BitacorasDTO> create(BitacorasDTO bitacorasDTO);

    public Optional<BitacorasDTO> update(BitacorasDTO bitacorasDTO, Long id);

    public void delete(Long id);

    public void deleteAll();
}

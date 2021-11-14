package org.una.municipalidad.services;


import org.hibernate.mapping.Value;
import org.springframework.data.repository.query.Param;
import org.una.municipalidad.dto.CobrosDTO;
import org.una.municipalidad.entities.Cobros;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface CobrosService {
    public Optional<List<CobrosDTO>> findAll();

    public Optional<CobrosDTO> findById(Long id);

    public Optional<CobrosDTO> findByCobrosPeriodo(String cobrosPeriodo);

    public Optional<CobrosDTO> findByCobrosMonto(Long cobrosMonto);

   public Optional<List<CobrosDTO>> findByCobrosFechaPagoBetween(Date startDate, Date endDate);

    public Optional<List<CobrosDTO>> findCobrosByCedulaContribuyente(@Param("cedulaContribuyente")String cedulaContribuyente);

    public Optional<List<CobrosDTO>> findByCobrosBetweenCedulaContribuyenteAndFecha(@Param("cedulaContribuyente")String cedulaContribuyente, @Param("startDate")Date startDate, @Param("endDate")Date endDate);

    public Optional<List<CobrosDTO>> findCobrosByCedulaContribuyentePendientes(@Param("cedulaContribuyente") String cedulaContribuyente);

    public Optional<List<CobrosDTO>> findCobrosByCedulaContribuyenteContaining(@Param("cedulaContribuyente")String cedulaContribuyente);

    public Optional<CobrosDTO> create(CobrosDTO cobrosDTO);

    public Optional<CobrosDTO> update(CobrosDTO cobrosDTO, Long id);

    public void delete(Long id);

    public void deleteAll();
}

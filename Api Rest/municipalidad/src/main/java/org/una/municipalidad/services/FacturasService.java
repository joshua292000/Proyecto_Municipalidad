package org.una.municipalidad.services;

import org.una.municipalidad.dto.ContribuyentesDTO;
import org.una.municipalidad.dto.FacturasDTO;


import java.util.Date;
import java.util.Optional;

public interface FacturasService {
    public Optional<FacturasDTO> findById(Long id);
    public Optional<FacturasDTO> findByFechaPago(Date fechapago);
    public Optional<FacturasDTO> create(FacturasDTO facturasDTO);
    public Optional<FacturasDTO> update(FacturasDTO facturasDTO);
}

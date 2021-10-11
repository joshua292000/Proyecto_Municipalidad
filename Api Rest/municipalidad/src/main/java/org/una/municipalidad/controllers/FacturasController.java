package org.una.municipalidad.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.una.municipalidad.dto.ContribuyentesDTO;
import org.una.municipalidad.dto.FacturasDTO;
import org.una.municipalidad.services.FacturasService;

import java.util.Date;
import java.util.Optional;

@RestController
@RequestMapping("/facturas")
@Api(tags = {"Facturas"})
public class FacturasController {
    @Autowired
    private FacturasService facturasService;

    @GetMapping("/{id}")
    @ApiOperation(value = "Obtiene una factura a partir de su id", response = FacturasDTO.class, tags = "Facturas")
    @PreAuthorize("hasRole('GESTOR')")
    public ResponseEntity<?> findById(@PathVariable(value = "id") Long id) {
        Optional<FacturasDTO> facturasFound = facturasService.findById(id);
        return new ResponseEntity<>(facturasFound, HttpStatus.OK);

    }

    @GetMapping("/fecha/{fecha}")
    @ApiOperation(value = "Obtiene una factura a partir de su fecha", response = ContribuyentesDTO.class, tags = "Facturas")
    @PreAuthorize("hasRole('GESTOR')")
    public ResponseEntity<?> findByFechaPago(@PathVariable(value = "fecha") Date fecha) {
        Optional<FacturasDTO>result = facturasService.findByFechaPago(fecha);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/")
    @ResponseBody
    @PreAuthorize("hasRole('GESTOR')")
    public ResponseEntity<?> create(@RequestBody FacturasDTO facturasDTO) {
        try {
            Optional<FacturasDTO> facturasCreated = facturasService.create(facturasDTO);
            return new ResponseEntity<>(facturasCreated, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/")
    @ApiOperation(value = "Actualiza la informacion", response = FacturasDTO.class, tags = "Facturas")
    @ResponseBody
    @PreAuthorize("hasRole('GESTOR')")
    public ResponseEntity<?> update(@RequestBody FacturasDTO facturasModified) {
        Optional<FacturasDTO> FacturasUpdated = facturasService.update(facturasModified);
        return new ResponseEntity<>(FacturasUpdated, HttpStatus.OK);
    }

}

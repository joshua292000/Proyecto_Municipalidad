package org.una.municipalidad.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.una.municipalidad.dto.CobrosDTO;
import org.una.municipalidad.dto.FechasCobrosDTO;
import org.una.municipalidad.services.CobrosService;
import org.una.municipalidad.services.FechasCobrosService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/fechascobros")
@Api(tags = {"FechasCobros"})
public class FechasCobrosController {
    @Autowired
    private FechasCobrosService fechascobrosService;

    @GetMapping()
    @ApiOperation(value = "Obtiene una lista de todos las fechas de cobros", response = FechasCobrosDTO.class, responseContainer = "List", tags = "FechasCobros")
    @PreAuthorize("hasRole('GESTOR') or hasRole('GERENTE') or hasRole('AUDITOR')")
    public @ResponseBody
    ResponseEntity<?> findAll() {
        Optional<List<FechasCobrosDTO>> result = fechascobrosService.findAll();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/")
    @ResponseBody
    @PreAuthorize("hasRole('GESTOR') or hasRole('GERENTE')")
    public ResponseEntity<?> create(@RequestBody FechasCobrosDTO fechasCobrosDTO) {
        try {
            Optional<FechasCobrosDTO> cobrosCreated = fechascobrosService.create(fechasCobrosDTO);
            return new ResponseEntity<>(cobrosCreated, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Actualiza por medio del id", response = FechasCobrosDTO.class, tags = "FechasCobros")
    @ResponseBody
    @PreAuthorize("hasRole('GESTOR') or hasRole('GERENTE')")
    public ResponseEntity<?> update(@PathVariable(value = "id") Long id, @RequestBody FechasCobrosDTO fechacobrosModified) {
        Optional<FechasCobrosDTO> fechacobrosUpdated = fechascobrosService.update(fechacobrosModified, id);
        return new ResponseEntity<>(fechacobrosUpdated, HttpStatus.OK);
    }
}

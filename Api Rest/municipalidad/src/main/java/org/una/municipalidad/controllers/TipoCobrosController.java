package org.una.municipalidad.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.una.municipalidad.dto.ContribuyentesDTO;
import org.una.municipalidad.dto.TipoCobrosDTO;
import org.una.municipalidad.services.TipoCobrosService;

import java.util.Optional;

@RestController
@RequestMapping("/tipocobros")
@Api(tags = {"TipoCobros"})
public class TipoCobrosController {
    @Autowired
    private TipoCobrosService tipoCobrosService;

    @GetMapping("/{id}")
    @ApiOperation(value = "Obtiene un tipo de cobro a partir de su id", response = TipoCobrosDTO.class, tags = "TipoCobros")
    @PreAuthorize("hasRole('GESTOR')")
    public ResponseEntity<?> findById(@PathVariable(value = "id") Long id) {
        Optional<TipoCobrosDTO> tipoCobrosFound = tipoCobrosService.findById(id);
        return new ResponseEntity<>(tipoCobrosFound, HttpStatus.OK);

    }

    @GetMapping("/nombre/{term}")
    @ApiOperation(value = "Obtiene un tipo de cobro a partir de su nombre", response = TipoCobrosDTO.class, tags = "TipoCobros")
    @PreAuthorize("hasRole('GESTOR')")
    public ResponseEntity<?> findByNombreTipoCobro(@PathVariable(value = "term") String term) {
        Optional<TipoCobrosDTO>result = tipoCobrosService.findByNombreTipoCobro(term);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/")
    @ResponseBody
    @PreAuthorize("hasRole('GESTOR')")
    public ResponseEntity<?> create(@RequestBody TipoCobrosDTO tipoCobrosDTO) {
        try {
            Optional<TipoCobrosDTO> tipoCobrosCreated = tipoCobrosService.create(tipoCobrosDTO);
            return new ResponseEntity<>(tipoCobrosCreated, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/")
    @ApiOperation(value = "Actualiza la informacion", response = TipoCobrosDTO.class, tags = "TipoCobros")
    @ResponseBody
    @PreAuthorize("hasRole('GESTOR')")
    public ResponseEntity<?> update(@RequestBody TipoCobrosDTO tipoCobrosModified) {
        Optional<TipoCobrosDTO> TipoCobrosUpdated = tipoCobrosService.update(tipoCobrosModified);
        return new ResponseEntity<>(TipoCobrosUpdated, HttpStatus.OK);
    }

}

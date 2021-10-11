package org.una.municipalidad.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.una.municipalidad.dto.ContribuyentesDTO;
import org.una.municipalidad.dto.LocalesMercadoDTO;
import org.una.municipalidad.services.LocalesMercadoService;

import java.util.Optional;

@RestController
@RequestMapping("/localesmercado")
@Api(tags = {"LocalesMercado"})
public class LocalesMercadoController {
    @Autowired
    private LocalesMercadoService localesMercadoService;

    @GetMapping("/{id}")
    @ApiOperation(value = "Obtiene un local del mercado a partir de su id", response = LocalesMercadoDTO.class, tags = "LocalesMercado")
    @PreAuthorize("hasRole('GESTOR')")
    public ResponseEntity<?> findById(@PathVariable(value = "id") Long id) {
        Optional<LocalesMercadoDTO> localesMercadoFound = localesMercadoService.findById(id);
        return new ResponseEntity<>(localesMercadoFound, HttpStatus.OK);

    }

    @GetMapping("/nombre/{term}")
    @ApiOperation(value = "Obtiene un local del mercado a partir de su nombre", response = LocalesMercadoDTO.class, tags = "LocalesMercado")
    @PreAuthorize("hasRole('GESTOR')")
    public ResponseEntity<?> findByNombreLocal(@PathVariable(value = "term") String term) {
        Optional<LocalesMercadoDTO>result = localesMercadoService.findByNombreLocal(term);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/")
    @ResponseBody
    @PreAuthorize("hasRole('GESTOR')")
    public ResponseEntity<?> create(@RequestBody LocalesMercadoDTO localesMercadoDTO) {
        try {
            Optional<LocalesMercadoDTO> localesMercadoCreated = localesMercadoService.create(localesMercadoDTO);
            return new ResponseEntity<>(localesMercadoCreated, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/")
    @ApiOperation(value = "Actualiza la informacion", response = LocalesMercadoDTO.class, tags = "LocalesMercado")
    @ResponseBody
    @PreAuthorize("hasRole('GESTOR')")
    public ResponseEntity<?> update(@RequestBody LocalesMercadoDTO localesMercadoModified) {
        Optional<LocalesMercadoDTO> LocalesMercadoUpdated =  localesMercadoService.update(localesMercadoModified);
        return new ResponseEntity<>(LocalesMercadoUpdated, HttpStatus.OK);
    }

}

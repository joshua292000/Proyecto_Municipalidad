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
import org.una.municipalidad.dto.PropiedadesDTO;
import org.una.municipalidad.services.PropiedadesService;

import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/propiedades")
@Api(tags = {"Propiedades"})

public class PropiedadesController {

    @Autowired
    private PropiedadesService propiedadesService;

    @GetMapping()
    @ApiOperation(value = "Obtiene una lista de todas las propiedades", response = PropiedadesDTO.class, responseContainer = "List", tags = "Propiedades")
    @PreAuthorize("hasRole('AUDITOR') or hasRole('GESTOR')")
    public @ResponseBody
    ResponseEntity<?> findAll() {
        Optional<List<PropiedadesDTO>> result = propiedadesService.findAll();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Obtiene una licencia comercial a partir de su id", response = PropiedadesDTO.class, tags = "Propiedades")
    @PreAuthorize("hasRole('GERENTE') or hasRole('GESTOR')")
    public ResponseEntity<?> findById(@PathVariable(value = "id") Long id) {
        Optional<PropiedadesDTO> propiedadesFound = propiedadesService.findById(id);
        return new ResponseEntity<>(propiedadesFound, HttpStatus.OK);
    }

    @GetMapping("/{codigoComercio}")
    @ApiOperation(value = "Obtiene una propiedad a partir de su valor de terreno", response = PropiedadesDTO.class, tags = "Propiedades")
    @PreAuthorize("hasRole('GESTOR')")
    public ResponseEntity<?> findByPropiedadValorTerreno(@PathVariable(value = "propiedadValorTerreno") Long propiedadValorTerreno) {
        Optional<PropiedadesDTO> propiedadesFound = propiedadesService.findByPropiedadValorTerreno(propiedadValorTerreno);
        return new ResponseEntity<>(propiedadesFound, HttpStatus.OK);
    }

    @GetMapping("/{nombreComercio}")
    @ApiOperation(value = "Obtiene una propiedad a partir de su valor de construccion", response = PropiedadesDTO.class, tags = "Propiedades")
    @PreAuthorize("hasRole('GESTOR')")
    public ResponseEntity<?> findByPropiedadValorConstruccion(@PathVariable(value = "propiedadValorConstruccion") Long propiedadValorConstruccion) {
        Optional<PropiedadesDTO> propiedadesFound = propiedadesService.findByPropiedadValorConstruccion(propiedadValorConstruccion);
        return new ResponseEntity<>(propiedadesFound, HttpStatus.OK);
    }

    @GetMapping("/findPropiedadesByCedula/{cedulaContribuyente}")
    @ApiOperation(value = "Obtiene una lista de las propiedades a partir de la cedula de un contribuyente", response = ContribuyentesDTO.class, tags = "LicenciasComerciales")
    @PreAuthorize("hasRole('GESTOR') or hasRole('BOT')")
    public ResponseEntity<?> findPropiedadesByCedula(@PathVariable(value = "cedulaContribuyente")String cedulaContribuyente) {
        try{
            Optional<List<PropiedadesDTO>> result = propiedadesService.findPropiedadesByCedula(cedulaContribuyente);
            return new ResponseEntity<>(result,HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/")
    @ResponseBody
    @PreAuthorize("hasRole('GESTOR')")
    public ResponseEntity<?> create(@RequestBody PropiedadesDTO propiedadesDTO) {
        try {
            Optional<PropiedadesDTO> propiedadesCreated = propiedadesService.create(propiedadesDTO);
            return new ResponseEntity<>(propiedadesCreated, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Actualiza por medio del id", response = PropiedadesDTO.class, tags = "Propiedades")
    @ResponseBody
    @PreAuthorize("hasRole('GESTOR')")
    public ResponseEntity<?> update(@PathVariable(value = "id") Long id, @RequestBody PropiedadesDTO propiedadesModified) {
        Optional<PropiedadesDTO> propiedadesUpdated = propiedadesService.update(propiedadesModified, id);
        return new ResponseEntity<>(propiedadesUpdated, HttpStatus.OK);
    }

    @ApiOperation(value = "Elimina una propiedad por medio del id", response = PropiedadesDTO.class, tags = "Propiedades")
    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('GESTOR')")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) throws Exception {
        propiedadesService.delete(id);
        return new ResponseEntity<>("Ok", HttpStatus.OK);
    }

    @ApiOperation(value = "Elimina todas las propiedades", response = PropiedadesDTO.class, tags = "Propiedades")
    @DeleteMapping("/")
    @PreAuthorize("hasRole('GESTOR')")
    public ResponseEntity<?> deleteAll() throws Exception {
        propiedadesService.deleteAll();
        return new ResponseEntity<>("Ok", HttpStatus.OK);

    }
}

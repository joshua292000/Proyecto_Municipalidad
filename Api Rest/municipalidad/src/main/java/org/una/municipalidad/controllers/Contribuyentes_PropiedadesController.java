package org.una.municipalidad.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.una.municipalidad.dto.CobrosDTO;
import org.una.municipalidad.dto.ContribuyentesDTO;
import org.una.municipalidad.dto.Contribuyentes_Locales_MercadoDTO;
import org.una.municipalidad.dto.Contribuyentes_PropiedadesDTO;
import org.una.municipalidad.services.Contribuyentes_PropiedadesService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/contribuyentes_propiedades")
@Api(tags = {"Contribuyentes_Propiedades"})
public class Contribuyentes_PropiedadesController {

    @Autowired
    private Contribuyentes_PropiedadesService contriuyenteproService;

    @GetMapping("/findContribuyentes_PropiedadesByCedula/{cedulaContribuyente}")
    @ApiOperation(value = "Obtiene una Propiedad a partir de la cedula de un contribuyente", response = Contribuyentes_PropiedadesDTO.class, responseContainer = "Contribuyentes_PropiedadesDTO" , tags = "Contribuyentes_Propiedades")
    @PreAuthorize("hasRole('GESTOR') or hasRole('BOT')")
    public ResponseEntity<?> findContribuyentes_PropiedadesByCedula(@PathVariable(value = "cedulaContribuyente")String cedulaContribuyente) {
        try{
            Optional<List<Contribuyentes_PropiedadesDTO>> result = contriuyenteproService.findContribuyentes_PropiedadesByCedula(cedulaContribuyente);
            return new ResponseEntity<>(result,HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/")
    @ResponseBody
    public ResponseEntity<?> create(@RequestBody Contribuyentes_PropiedadesDTO contProDTO) {
        try {
            Optional<Contribuyentes_PropiedadesDTO> ContriProCreated = contriuyenteproService.create(contProDTO);
            return new ResponseEntity<>(ContriProCreated, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/")
    @ApiOperation(value = "Actualiza la informacion", response = Contribuyentes_PropiedadesDTO.class, tags = "Contribuyentes_Propiedades")
    @ResponseBody
    public ResponseEntity<?> update(@RequestBody Contribuyentes_PropiedadesDTO ContriProModified) {
        Optional<Contribuyentes_PropiedadesDTO> ContriproUpdated = contriuyenteproService.update(ContriProModified);
        return new ResponseEntity<>(ContriproUpdated, HttpStatus.OK);
    }



    @ApiOperation(value = "Elimina todos los contribuyentes relacionados a una propiedad", response = Contribuyentes_PropiedadesDTO.class, tags = "Contribuyentes_Propiedades")
    @DeleteMapping("/")
    public ResponseEntity<?> deleteAll() throws Exception {
        contriuyenteproService.deleteAll();
        return new ResponseEntity<>("Ok", HttpStatus.OK);
    }
}

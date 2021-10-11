package org.una.municipalidad.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.una.municipalidad.dto.ContribuyentesDTO;
import org.una.municipalidad.services.ContribuyentesService;

import java.util.Optional;


@RestController
@RequestMapping("/contribuyentes")
@Api(tags = {"Contribuyentes"})
public class ContribuyentesController {
    @Autowired
    private ContribuyentesService contribuyentesService;

    @GetMapping("/{id}")
    @ApiOperation(value = "Obtiene un contribuyente a partir de su id", response = ContribuyentesDTO.class, tags = "Contribuyentes")
    public ResponseEntity<?> findById(@PathVariable(value = "id") Long id) {
        Optional<ContribuyentesDTO> contribuyenteFound = contribuyentesService.findById(id);
        return new ResponseEntity<>(contribuyenteFound, HttpStatus.OK);

    }

    @GetMapping("/nombre/{term}")
    @ApiOperation(value = "Obtiene un contribuyente a partir de su nombre", response = ContribuyentesDTO.class, tags = "Contribuyentes")
    public ResponseEntity<?> findByNombreContribuyente(@PathVariable(value = "term") String term) {
        Optional<ContribuyentesDTO>result = contribuyentesService.findByNombreContribuyente(term);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/{cedula}")
    @ApiOperation(value = "Obtiene un contribuyente a partir de su cedula", response = ContribuyentesDTO.class, tags = "Contribuyentes")
    public ResponseEntity<?> findByCedulaContribuyente(@PathVariable(value = "cedula")Long cedula) {
        Optional<ContribuyentesDTO>result = contribuyentesService.findByCedulaContribuyente(cedula);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }


    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/")
    @ResponseBody
    public ResponseEntity<?> create(@RequestBody ContribuyentesDTO contribuyenteDTO) {
        try {
            Optional<ContribuyentesDTO> contribuyenteCreated = contribuyentesService.create(contribuyenteDTO);
            return new ResponseEntity<>(contribuyenteCreated, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/")
    @ApiOperation(value = "Actualiza la informacion", response = ContribuyentesDTO.class, tags = "Contribuyentes")
    @ResponseBody
    public ResponseEntity<?> update(@RequestBody ContribuyentesDTO contribuyenteModified) {
        Optional<ContribuyentesDTO> ContribuyenteUpdated = contribuyentesService.update(contribuyenteModified);
        return new ResponseEntity<>(ContribuyenteUpdated, HttpStatus.OK);
    }
}

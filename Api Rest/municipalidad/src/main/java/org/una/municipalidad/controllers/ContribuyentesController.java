package org.una.municipalidad.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.una.municipalidad.dto.CobrosDTO;
import org.una.municipalidad.dto.ContribuyentesDTO;
import org.una.municipalidad.entities.Contribuyentes;
import org.una.municipalidad.services.ContribuyentesService;
import org.una.municipalidad.utils.MapperUtils;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/contribuyentes")
@Api(tags = {"Contribuyentes"})
public class ContribuyentesController {
    @Autowired
    private ContribuyentesService contribuyentesService;

    @GetMapping("/{id}")
    @ApiOperation(value = "Obtiene un contribuyente a partir de su id", response = ContribuyentesDTO.class, tags = "Contribuyentes")
    @PreAuthorize("hasRole('GESTOR')")
    public ResponseEntity<?> findById(@PathVariable(value = "id") Long id) {
        Optional<ContribuyentesDTO> contribuyenteFound = contribuyentesService.findById(id);
        return new ResponseEntity<>(contribuyenteFound, HttpStatus.OK);

    }

    @GetMapping("/findByNombreContribuyente/{nombreContribuyente}")
    @ApiOperation(value = "Obtiene un contribuyente a partir de su nombre", response = ContribuyentesDTO.class, tags = "Contribuyentes")
    @PreAuthorize("hasRole('GESTOR')")
    public ResponseEntity<?> findByNombreContribuyente(@PathVariable(value = "nombreContribuyente") String nombreContribuyente) {
        Optional<ContribuyentesDTO>contribuyenteFound= contribuyentesService.findByNombreContribuyente(nombreContribuyente);
        return new ResponseEntity<>(contribuyenteFound, HttpStatus.OK);
    }

    @GetMapping("/findByCedulaContribuyente/{cedulaContribuyente}")
    @ApiOperation(value = "Obtiene un contribuyente a partir de su cedula", response = ContribuyentesDTO.class, tags = "Contribuyentes")
    @PreAuthorize("hasRole('GESTOR') or hasRole('BOT')")
    public ResponseEntity<?> findByCedulaContribuyente(@PathVariable(value = "cedulaContribuyente")String cedulaContribuyente) {
        Optional<ContribuyentesDTO>contribuyenteFound = contribuyentesService.findByCedulaContribuyente(cedulaContribuyente);
        return new ResponseEntity<>(contribuyenteFound, HttpStatus.OK);
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/")
    @ResponseBody
    @PreAuthorize("hasRole('GESTOR')")
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
    @PreAuthorize("hasRole('GESTOR')")
    public ResponseEntity<?> update(@RequestBody ContribuyentesDTO contribuyenteModified) {
        Optional<ContribuyentesDTO> ContribuyenteUpdated = contribuyentesService.update(contribuyenteModified);
        return new ResponseEntity<>(ContribuyenteUpdated, HttpStatus.OK);
    }
}

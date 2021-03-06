package org.una.municipalidad.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.una.municipalidad.dto.ContribuyentesDTO;
import org.una.municipalidad.dto.Contribuyentes_Licencias_ComercialesDTO;
import org.una.municipalidad.services.Contribuyentes_Lic_ComercialesService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/contribuyentes_licencias_comerciales")
@Api(tags = {"Contribuyentes_Licencias_Comerciales"})
public class Contribuyente_Lic_ComercialController {
    @Autowired
    private Contribuyentes_Lic_ComercialesService contriuyenteliccomService;

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/")
    @ResponseBody
    public ResponseEntity<?> create(@RequestBody Contribuyentes_Licencias_ComercialesDTO contLicComDTO) {
        try {
            Optional<Contribuyentes_Licencias_ComercialesDTO> ContriLicComCreated = contriuyenteliccomService.create(contLicComDTO);
            return new ResponseEntity<>(ContriLicComCreated, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/findContribuyentes_Licencias_ComercialesByCedula/{cedulaContribuyente}")
    @ApiOperation(value = "Obtiene una licencias comercial a partir de la cedula de un contribuyente", response = ContribuyentesDTO.class, tags = "Contribuyentes_Licencias_Comerciales")
    @PreAuthorize("hasRole('GESTOR') or hasRole('BOT')")
    public ResponseEntity<?> findContribuyentes_Licencias_ComercialesByCedula(@PathVariable(value = "cedulaContribuyente")String cedulaContribuyente) {
        try{
            Optional<List<Contribuyentes_Licencias_ComercialesDTO>> result = contriuyenteliccomService.findContribuyentes_Licencias_ComercialesByCedula(cedulaContribuyente);
            return new ResponseEntity<>(result,HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/")
    @ApiOperation(value = "Actualiza la informacion", response = Contribuyentes_Licencias_ComercialesDTO.class, tags = "Contribuyentes_Licencias_Comerciales")
    @ResponseBody
    public ResponseEntity<?> update(@RequestBody Contribuyentes_Licencias_ComercialesDTO ContriLicComModified) {
        Optional<Contribuyentes_Licencias_ComercialesDTO> ContriLicComUpdated = contriuyenteliccomService.update(ContriLicComModified);
        return new ResponseEntity<>(ContriLicComUpdated, HttpStatus.OK);
    }



    @ApiOperation(value = "Elimina todos los contribuyentes relacionados a una licencia comercial", response = Contribuyentes_Licencias_ComercialesDTO.class, tags = "Contribuyentes_Licencias_Comerciales")
    @DeleteMapping("/")
    public ResponseEntity<?> deleteAll() throws Exception {
        contriuyenteliccomService.deleteAll();
        return new ResponseEntity<>("Ok", HttpStatus.OK);
    }
}

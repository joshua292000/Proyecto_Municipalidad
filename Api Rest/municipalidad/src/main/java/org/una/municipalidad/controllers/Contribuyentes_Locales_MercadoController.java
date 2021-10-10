package org.una.municipalidad.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.una.municipalidad.dto.Contribuyentes_Locales_MercadoDTO;
import org.una.municipalidad.services.Contribuyentes_Loc_MercadoService;


import java.util.Optional;

@RestController
@RequestMapping("/contribuyentes_Locales_Mercado")
@Api(tags = {"Contribuyentes_Locales_Mercado"})
public class Contribuyentes_Locales_MercadoController {
    @Autowired
    private Contribuyentes_Loc_MercadoService contribuyentes_loc_mercadoService;

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/")
    @ResponseBody
    public ResponseEntity<?> create(@RequestBody Contribuyentes_Locales_MercadoDTO contLocMercDTO) {
        try {
            Optional<Contribuyentes_Locales_MercadoDTO> contLocMercCreated = contribuyentes_loc_mercadoService.create(contLocMercDTO);
            return new ResponseEntity<>(contLocMercCreated, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/")
    @ApiOperation(value = "Actualiza la informacion", response = Contribuyentes_Locales_MercadoDTO.class, tags = "Seguridad")
    @ResponseBody
    public ResponseEntity<?> update(@RequestBody Contribuyentes_Locales_MercadoDTO contLocMercModified) {
        Optional<Contribuyentes_Locales_MercadoDTO> ContLocMercUpdated = contribuyentes_loc_mercadoService.update(contLocMercModified);
        return new ResponseEntity<>(ContLocMercUpdated, HttpStatus.OK);
    }



    @ApiOperation(value = "Elimina todos los contribuyentes relacionados a un local del mercado", response = Contribuyentes_Locales_MercadoDTO.class, tags = "Seguridad")
    @DeleteMapping("/")
    public ResponseEntity<?> deleteAll() throws Exception {
        contribuyentes_loc_mercadoService.deleteAll();
        return new ResponseEntity<>("Ok", HttpStatus.OK);
    }
}

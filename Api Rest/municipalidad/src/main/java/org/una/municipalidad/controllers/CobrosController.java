package org.una.municipalidad.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.una.municipalidad.dto.CobrosDTO;
import org.una.municipalidad.entities.Cobros;
import org.una.municipalidad.services.CobrosService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cobros")
@Api(tags = {"Cobros"})
public class CobrosController {
    @Autowired
    private CobrosService cobrosService;

    @GetMapping()
    @ApiOperation(value = "Obtiene una lista de todos los cobros", response = CobrosDTO.class, responseContainer = "List", tags = "Cobros")
    public @ResponseBody
    ResponseEntity<?> findAll() {
        Optional<List<CobrosDTO>> result = cobrosService.findAll();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Obtiene un cobro a partir de su id", response = CobrosDTO.class, tags = "Cobros")
    public ResponseEntity<?> findById(@PathVariable(value = "id") Long id) {
        Optional<CobrosDTO> cobrosFound = cobrosService.findById(id);
        return new ResponseEntity<>(cobrosFound, HttpStatus.OK);
    }

    @GetMapping("/{cobrosPeriodo}")
    @ApiOperation(value = "Obtiene el periodo de un cobro", response = CobrosDTO.class, tags = "Cobros")
    public ResponseEntity<?> findByCobrosPeriodo(@PathVariable(value = "cobrosPeriodo") String cobrosPeriodo) {
        Optional<CobrosDTO> cobrosFound = cobrosService.findByCobrosPeriodo(cobrosPeriodo);
        return new ResponseEntity<>(cobrosFound, HttpStatus.OK);
    }

    @GetMapping("/{cobrosMonto}")
    @ApiOperation(value = "Obtiene el monto de un cobro", response = CobrosDTO.class, tags = "Cobros")
    public ResponseEntity<?> findByCobrosMonto(@PathVariable(value = "cobrosMonto") Long cobrosMonto) {
        Optional<CobrosDTO> cobrosFound = cobrosService.findByCobrosMonto(cobrosMonto);
        return new ResponseEntity<>(cobrosFound, HttpStatus.OK);
    }
    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/")
    @ResponseBody
    public ResponseEntity<?> create(@RequestBody CobrosDTO cobrosDTO) {
        try {
            Optional<CobrosDTO> cobrosCreated = cobrosService.create(cobrosDTO);
            return new ResponseEntity<>(cobrosCreated, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Actualiza por medio del id", response = CobrosDTO.class, tags = "Seguridad")
    @ResponseBody
    public ResponseEntity<?> update(@PathVariable(value = "id") Long id, @RequestBody CobrosDTO cobrosModified) {
        Optional<CobrosDTO> cobrosUpdated = cobrosService.update(cobrosModified, id);
        return new ResponseEntity<>(cobrosUpdated, HttpStatus.OK);
    }

    @ApiOperation(value = "Elimina un cobro por medio del id", response = CobrosDTO.class, tags = "Seguridad")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) throws Exception {
        cobrosService.delete(id);
        return new ResponseEntity<>("Ok", HttpStatus.OK);
    }

    @ApiOperation(value = "Elimina todos los cobros", response = CobrosDTO.class, tags = "Seguridad")
    @DeleteMapping("/")
    public ResponseEntity<?> deleteAll() throws Exception {
        cobrosService.deleteAll();
        return new ResponseEntity<>("Ok", HttpStatus.OK);

    }
}

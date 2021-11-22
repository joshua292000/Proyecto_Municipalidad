package org.una.municipalidad.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.una.municipalidad.dto.BitacorasDTO;
import org.una.municipalidad.dto.CobrosDTO;
import org.una.municipalidad.services.BitacorasService;

import java.util.Date;
import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/bitacora")
@Api(tags = {"Bitacora"})
public class BitacoraController {

    @Autowired
    private BitacorasService bitacoraService;

    @GetMapping()
    @ApiOperation(value = "Obtiene una lista de todas las Licencias Comerciales.", response = BitacorasDTO.class, responseContainer = "List", tags = "Bitacora")
    @PreAuthorize("hasRole('GERENTE') or hasRole('AUDITOR')")
    public @ResponseBody
    ResponseEntity<?> findAll() {
        Optional<List<BitacorasDTO>> result = bitacoraService.findAll();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/findById/{id}")
    @ApiOperation(value = "Obtiene una bitacora a partir de su id", response = BitacorasDTO.class, tags = "Bitacora")
    @PreAuthorize("hasRole('AUDITOR')")
    public ResponseEntity<?> findById(@PathVariable(value = "id") Long id) {
        Optional<BitacorasDTO> bitacoraFound = bitacoraService.findById(id);
        return new ResponseEntity<>(bitacoraFound, HttpStatus.OK);
    }

    @GetMapping("/findByBitacoraTabla/{bitacoraTabla}")
    @ApiOperation(value = "Obtiene una tabla de la bitacora", response = BitacorasDTO.class, tags = "Bitacora")
    @PreAuthorize("hasRole('AUDITOR')")
    public ResponseEntity<?> findByBitacoraTabla(@PathVariable(value = "bitacoraTabla") String bitacoraTabla) {
        Optional<BitacorasDTO> bitacoraFound = bitacoraService.findByBitacoraTabla(bitacoraTabla);
        return new ResponseEntity<>(bitacoraFound, HttpStatus.OK);
    }

    @GetMapping("/findByBitacoraDescripcion/{bitacoraDescripcion}")
    @ApiOperation(value = "Obtiene una descripcion de la bitacora", response = BitacorasDTO.class, tags = "Bitacora")
    @PreAuthorize("hasRole('AUDITOR')")
    public ResponseEntity<?> findByBitacoraDescripcion(@PathVariable(value = "bitacoraDescripcion") String bitacoraDescripcion) {
        Optional<BitacorasDTO> bitacoraFound = bitacoraService.findByBitacoraDescripcion(bitacoraDescripcion);
        return new ResponseEntity<>(bitacoraFound, HttpStatus.OK);
    }


    @GetMapping("/findByIdBetweenFecha/{idUsuario}/{startDate}/{endDate}")
    @ApiOperation(value = "Obtiene una lista de movimientos realizados de acuerdo al id de un usuario y dos fechas dadas", response = BitacorasDTO.class, responseContainer = "BitacorasDTO", tags = "Bitacora")
    public ResponseEntity<?> findByIdBetweenFecha(@PathVariable(value = "idUsuario") Long id, @PathVariable(value = "startDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate, @PathVariable(value = "endDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate) {
        try {
            Optional<List<BitacorasDTO>> result = bitacoraService.findByIdBetweenFecha(id,startDate,endDate);
            return new ResponseEntity<>(result, HttpStatus.OK);
        }  catch(Exception e){
            return new ResponseEntity<>(e,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/findByBitacoraCambiosBetweenFecha/{startDate}/{endDate}")
    @ApiOperation(value = "Obtiene una lista de cambios en base a las fechas", response = BitacorasDTO.class, responseContainer = "BitacorasDTO" , tags = "Bitacora")
    @PreAuthorize("hasRole('AUDITOR')")
    public ResponseEntity<?> findByBitacoraCambiosBetweenFecha(@PathVariable(value = "startDate") @DateTimeFormat(pattern = "yyyy-MM-dd")Date startDate, @PathVariable(value = "endDate") @DateTimeFormat(pattern = "yyyy-MM-dd")Date endDate){
        try{
            Optional<List<BitacorasDTO>> result = bitacoraService.findByBitacoraCambiosBetweenFecha(startDate,endDate);
            return new ResponseEntity<>(result,HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/findByIdUsuario/{id}")
    @ApiOperation(value = "Obtiene una bitacora a partir del id de un usuario", response = BitacorasDTO.class, tags = "Bitacora")
    @PreAuthorize("hasRole('AUDITOR')")
    public ResponseEntity<?> findByIdUsuario(@PathVariable(value = "id") Long id) {
        Optional<BitacorasDTO> bitacoraFound = bitacoraService.findByIdUsuario(id);
        return new ResponseEntity<>(bitacoraFound, HttpStatus.OK);
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/")
    @ResponseBody
    @PreAuthorize("hasRole('GESTOR') or hasRole('GERENTE')")
    public ResponseEntity<?> create(@RequestBody BitacorasDTO bitacoraDTO) {
        try {
            Optional<BitacorasDTO> bitacoraCreated = bitacoraService.create(bitacoraDTO);
            return new ResponseEntity<>(bitacoraCreated, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PutMapping("/{id}")
    @ApiOperation(value = "Actualiza por medio del id", response = BitacorasDTO.class, tags = "Bitacora")
    @ResponseBody
    @PreAuthorize("hasRole('GESTOR')")
    public ResponseEntity<?> update(@PathVariable(value = "id") Long id, @RequestBody BitacorasDTO bitacoraModified) {
        Optional<BitacorasDTO> bitacoraUpdated = bitacoraService.update(bitacoraModified, id);
        return new ResponseEntity<>(bitacoraUpdated, HttpStatus.OK);
    }

    @ApiOperation(value = "Elimina una bitacora por medio del id", response = BitacorasDTO.class, tags = "Bitacora")
    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('GESTOR')")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) throws Exception {
        bitacoraService.delete(id);
        return new ResponseEntity<>("Ok", HttpStatus.OK);
    }

    @ApiOperation(value = "Elimina todas las bitacoras", response = BitacorasDTO.class, tags = "Bitacora")
    @DeleteMapping("/")
    @PreAuthorize("hasRole('GESTOR')")
    public ResponseEntity<?> deleteAll() throws Exception {
        bitacoraService.deleteAll();
        return new ResponseEntity<>("Ok", HttpStatus.OK);

    }
}

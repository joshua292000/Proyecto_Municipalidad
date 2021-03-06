package org.una.municipalidad.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.una.municipalidad.dto.CobrosDTO;
import org.una.municipalidad.entities.Cobros;
import org.una.municipalidad.services.CobrosService;
import org.una.municipalidad.utils.MapperUtils;

import java.util.Date;
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
    @PreAuthorize("hasRole('GESTOR') or hasRole('GERENTE') or hasRole('AUDITOR')")
    public @ResponseBody
    ResponseEntity<?> findAll() {
        Optional<List<CobrosDTO>> result = cobrosService.findAll();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Obtiene un cobro a partir de su id", response = CobrosDTO.class, tags = "Cobros")
    @PreAuthorize("hasRole('GESTOR')")
    public ResponseEntity<?> findById(@PathVariable(value = "id") Long id) {
        try {
            Optional<CobrosDTO> cobrosFound = cobrosService.findById(id);
            return new ResponseEntity<>(cobrosFound, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/findByEstado/{Estado}")
    @ApiOperation(value = "Obtiene cobros a partir de su estado", response = CobrosDTO.class, tags = "Cobros")
    @PreAuthorize("hasRole('GERENTE')")
    public ResponseEntity<?> findByEstado(@PathVariable(value = "Estado") String Estado) {
        try{
            Optional<List<CobrosDTO>> result = cobrosService.findByEstado(Estado);
            return new ResponseEntity<>(result,HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/findBycobrosPeriodo/{cobrosPeriodo}")
    @ApiOperation(value = "Obtiene el periodo de un cobro", response = CobrosDTO.class, tags = "Cobros")
    @PreAuthorize("hasRole('GESTOR') or hasRole('GERENTE')")
    public ResponseEntity<?> findByCobrosPeriodo(@PathVariable(value = "cobrosPeriodo") String cobrosPeriodo) {
        Optional<CobrosDTO> cobrosFound = cobrosService.findByCobrosPeriodo(cobrosPeriodo);
        return new ResponseEntity<>(cobrosFound, HttpStatus.OK);
    }

    @GetMapping("/findByCobrosMonto/{cobrosMonto}")
    @ApiOperation(value = "Obtiene el monto de un cobro", response = CobrosDTO.class, tags = "Cobros")
    @PreAuthorize("hasRole('GESTOR')")
    public ResponseEntity<?> findByCobrosMonto(@PathVariable(value = "cobrosMonto") Long cobrosMonto) {
        Optional<CobrosDTO> cobrosFound = cobrosService.findByCobrosMonto(cobrosMonto);
        return new ResponseEntity<>(cobrosFound, HttpStatus.OK);
    }

    @GetMapping("/findByCobrosBetweenFechaPago/{startDate}/{endDate}")
    @ApiOperation(value = "Obtiene una lista de cobros pagados", response = CobrosDTO.class, responseContainer = "CobrosDTO" , tags = "Cobros")
    @PreAuthorize("hasRole('GESTOR') or hasRole('GERENTE')")
    public ResponseEntity<?> findByCobrosBetweenFechaPago(@PathVariable(value = "startDate") @DateTimeFormat(pattern = "yyyy-MM-dd")Date startDate, @PathVariable(value = "endDate") @DateTimeFormat(pattern = "yyyy-MM-dd")Date endDate){
        try{
            Optional<List<CobrosDTO>> result = cobrosService.findByCobrosBetweenFechaPago(startDate,endDate);
            return new ResponseEntity<>(result,HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PreAuthorize("hasRole('ADMINISTRADOR') or hasRole('BOT')")
    @GetMapping("/findByCobrosBetweenCedulaContribuyenteAndFecha/{cedulaContribuyente}/{startDate}/{endDate}/{Estadito}")
    @ApiOperation(value = "Obtiene una lista de cobros cancelados de acuerdo a la cedula del contribuyente y dos fechas dadas", response = CobrosDTO.class, responseContainer = "CobrosDTO", tags = "Cobros")
    public ResponseEntity<?> findByCobrosBetweenCedulaContribuyenteAndFecha(@PathVariable(value = "cedulaContribuyente") String cedulaContribuyente, @PathVariable(value = "startDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate, @PathVariable(value = "endDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate, @PathVariable(value = "Estadito") String Estadito) {
        try {
            Optional<List<CobrosDTO>> result = cobrosService.findByCobrosBetweenCedulaContribuyenteAndFecha(cedulaContribuyente,startDate,endDate,Estadito);
            return new ResponseEntity<>(result, HttpStatus.OK);
        }  catch(Exception e){
            return new ResponseEntity<>(e,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PreAuthorize("hasRole('AUDITOR')")
    @GetMapping("/findByEstadoBetweenFecha/{Estadito}/{startDate}/{endDate}")
    @ApiOperation(value = "Obtiene una lista de cobros a partir de su estado y dos fechas dadas", response = CobrosDTO.class, responseContainer = "CobrosDTO", tags = "Cobros")
    public ResponseEntity<?>findByEstadoBetweenFecha(@PathVariable(value = "Estadito") String estado, @PathVariable(value = "startDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate, @PathVariable(value = "endDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate) {
        try {
            Optional<List<CobrosDTO>> result = cobrosService.findByEstadoBetweenFecha(estado,startDate,endDate);
            return new ResponseEntity<>(result, HttpStatus.OK);
        }  catch(Exception e){
            return new ResponseEntity<>(e,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PreAuthorize("hasRole('ADMINISTRADOR') or hasRole('BOT') or hasRole('GESTOR')")
    @GetMapping("/findCobrosByCedulaContribuyente/{cedulaContribuyente}/{Estadito}")
    @ApiOperation(value = "Obtiene una lista de cobros pagados", response = CobrosDTO.class, responseContainer = "CobrosDTO" , tags = "Cobros")
    public ResponseEntity<?> findCobrosByCedulaContribuyente(@PathVariable (value ="cedulaContribuyente") String cedula, @PathVariable (value ="Estadito") String Estadito){
        try{
            Optional<List<CobrosDTO>> result = cobrosService.findCobrosByCedulaContribuyente(cedula,Estadito);
            return new ResponseEntity<>(result,HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PreAuthorize("hasRole('ADMINISTRADOR') or hasRole('BOT') or hasRole('GESTOR')")
    @GetMapping("/findCobrosByCedulaContribuyente2/{cedulaContribuyente}/{Estadito}")
    @ApiOperation(value = "Obtiene una lista de cobros pagados", response = CobrosDTO.class, responseContainer = "CobrosDTO" , tags = "Cobros")
    public ResponseEntity<?> findCobrosByCedulaContribuyente2(@PathVariable (value ="cedulaContribuyente") String cedula, @PathVariable (value ="Estadito") String Estadito){
        try{
            Optional<List<CobrosDTO>> result = cobrosService.findCobrosByCedulaContribuyente2(cedula,Estadito);
            return new ResponseEntity<>(result,HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PreAuthorize("hasRole('ADMINISTRADOR') or hasRole('BOT') or hasRole('GESTOR')")
    @GetMapping("/findCobrosByCedulaContribuyente3/{cedulaContribuyente}/{Estadito}")
    @ApiOperation(value = "Obtiene una lista de cobros pagados", response = CobrosDTO.class, responseContainer = "CobrosDTO" , tags = "Cobros")
    public ResponseEntity<?> findCobrosByCedulaContribuyente3(@PathVariable (value ="cedulaContribuyente") String cedula, @PathVariable (value ="Estadito") String Estadito){
        try{
            Optional<List<CobrosDTO>> result = cobrosService.findCobrosByCedulaContribuyente3(cedula,Estadito);
            return new ResponseEntity<>(result,HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/cobrosmasivos")
    @ApiOperation(value = "Precedimiento almacenado", response = CobrosDTO.class, responseContainer = "CobrosDTO" , tags = "Cobros")
    @PreAuthorize("hasRole('GESTOR') or hasRole('GERENTE')")
    public void cobrosmasivos() {
        cobrosService.cobrosmasivos();
    }

    @GetMapping("/CobrosMasivoPropiedades/{Fecha_Inicial}")
    @ApiOperation(value = "Precedimiento almacenado", response = CobrosDTO.class, responseContainer = "CobrosDTO" , tags = "Cobros")
    @PreAuthorize("hasRole('GESTOR') or hasRole('GERENTE')")
    public ResponseEntity<?> CobrosMasivoPropiedades(@PathVariable (value ="Fecha_Inicial")@DateTimeFormat(pattern = "yyyy-MM-dd") Date Fecha_Inicial) {
        try{
            cobrosService.CobrosMasivoPropiedades(Fecha_Inicial);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e,HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/CobrosMasivosLocales/{Fecha_Inicial}")
    @ApiOperation(value = "Precedimiento almacenado", response = CobrosDTO.class, responseContainer = "CobrosDTO" , tags = "Cobros")
    @PreAuthorize("hasRole('GESTOR') or hasRole('GERENTE')")
    public ResponseEntity<?> CobrosMasivosLocales(@PathVariable (value ="Fecha_Inicial")@DateTimeFormat(pattern = "yyyy-MM-dd") Date Fecha_Inicial) {
        try{
            cobrosService.CobrosMasivosLocales(Fecha_Inicial);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e,HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/CobrosMasivoLicencias/{Fecha_Inicial}")
    @ApiOperation(value = "Precedimiento almacenado", response = CobrosDTO.class, responseContainer = "CobrosDTO" , tags = "Cobros")
    @PreAuthorize("hasRole('GESTOR') or hasRole('GERENTE')")
    public ResponseEntity<?> CobrosMasivoLicencias(@PathVariable (value ="Fecha_Inicial")@DateTimeFormat(pattern = "yyyy-MM-dd") Date Fecha_Inicial) {
        try{
            cobrosService.CobrosMasivoLicencias(Fecha_Inicial);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e,HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    @PreAuthorize("hasRole('GESTOR') or hasRole('BOT')")
    @GetMapping("/findCobrosByCedulaContribuyenteContaining/{cedulaContribuyente}")
    @ApiOperation(value = "Obtiene una lista de cobros pagados", response = CobrosDTO.class, responseContainer = "CobrosDTO" , tags = "Cobros")
    public ResponseEntity<?> findCobrosByCedulaContribuyenteContaining(@PathVariable (value ="cedulaContribuyente") String cedula){
        try{
            Optional<List<CobrosDTO>> result = cobrosService.findCobrosByCedulaContribuyenteContaining(cedula);
            return new ResponseEntity<>(result,HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PreAuthorize("hasRole('ADMINISTRADOR') or hasRole('BOT') or hasRole('GESTOR')")
    @GetMapping("/findCobrosByCedulaContribuyentePendientes/{cedulaContribuyente}")
    @ApiOperation(value = "Obtiene una lista de cobros pendientes", response = CobrosDTO.class, responseContainer = "CobrosDTO" , tags = "Cobros")
    public ResponseEntity<?> findCobrosByCedulaContribuyentePendientes(@PathVariable (value ="cedulaContribuyente") String cedula){
        try{
            Optional<List<CobrosDTO>> result = cobrosService.findCobrosByCedulaContribuyentePendientes(cedula);
            return new ResponseEntity<>(result,HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/")
    @ResponseBody
    @PreAuthorize("hasRole('GESTOR')")
    public ResponseEntity<?> create(@RequestBody CobrosDTO cobrosDTO) {
        try {
            Optional<CobrosDTO> cobrosCreated = cobrosService.create(cobrosDTO);
            return new ResponseEntity<>(cobrosCreated, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Actualiza por medio del id", response = CobrosDTO.class, tags = "Cobros")
    @ResponseBody
    @PreAuthorize("hasRole('GESTOR')")
    public ResponseEntity<?> update(@PathVariable(value = "id") Long id, @RequestBody CobrosDTO cobrosModified) {
        Optional<CobrosDTO> cobrosUpdated = cobrosService.update(cobrosModified, id);
        return new ResponseEntity<>(cobrosUpdated, HttpStatus.OK);
    }

    @ApiOperation(value = "Elimina un cobro por medio del id", response = CobrosDTO.class, tags = "Cobros")
    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('GERENTE')")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) throws Exception {
        cobrosService.delete(id);
        return new ResponseEntity<>("Ok", HttpStatus.OK);
    }

    @ApiOperation(value = "Elimina todos los cobros", response = CobrosDTO.class, tags = "Cobros")
    @DeleteMapping("/")
    @PreAuthorize("hasRole('GERENTE')")
    public ResponseEntity<?> deleteAll() throws Exception {
        cobrosService.deleteAll();
        return new ResponseEntity<>("Ok", HttpStatus.OK);

    }
}

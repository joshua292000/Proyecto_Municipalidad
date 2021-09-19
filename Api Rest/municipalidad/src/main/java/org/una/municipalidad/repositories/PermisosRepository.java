package org.una.municipalidad.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.una.municipalidad.entities.Permisos;

import java.util.List;

public interface PermisosRepository extends JpaRepository<Permisos, Long>{

    //public Permisos findByNombreRolAndDescripcionRol(String nombreRol, String descripcionRol);

    public List<Permisos> findByNombrePermisoContainingIgnoreCase(String nombrePermiso);

    public List<Permisos> findByNombrePermisoContaining(String nombrePermiso);
}

package org.una.municipalidad.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.una.municipalidad.entities.Roles;

import java.util.List;

@Repository
public interface RolesRepository extends JpaRepository<Roles, Long>{
    public Roles findByNombreRolAndDescripcionRol(String nombreRol, String descripcionRol);

    public List<Roles> findByNombreRolContainingIgnoreCase(String nombreRol);

    public List<Roles> findByNombreRolContaining(String nombreRol);

}

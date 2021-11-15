package org.una.municipalidad.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.una.municipalidad.entities.Usuarios;
import java.util.List;
import java.util.Optional;

@Repository
public interface UsuariosRepository extends JpaRepository<Usuarios, Long>{

    public Usuarios findByCedulaAndClaveEncriptado(String cedula, String claveEncriptado);

    public List<Usuarios> findByNombreUsuarioContainingIgnoreCase(String nombreUsuario);

    public List<Usuarios> findByCedulaContaining(String cedula);

    public Optional<Usuarios> findByCedula(String cedula);




}

package org.una.municipalidad.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.una.municipalidad.entities.Usuarios;
import java.util.List;

@Repository
public interface UsuariosRepository extends JpaRepository<Usuarios, Long>{
    public Usuarios findByNombreUsuarioAndClaveEncriptado(String nombreUsuario, String claveEncriptado);

    public List<Usuarios> findByNombreUsuarioContainingIgnoreCase(String nombreUsuario);

   public List<Usuarios> findByNombreUsuarioContaining(String nombreUsuario);



    //@Query("select u from Usuario u where UPPER(u.nombreCompleto) like CONCAT('%',UPPER(:nombreCompleto),'%')\"")
    //public Usuario findNombreCompletoWithLikeSQL(@Param("nombreCompleto")String nombreCompleto);
}

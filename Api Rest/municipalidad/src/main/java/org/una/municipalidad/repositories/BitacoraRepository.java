package org.una.municipalidad.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.una.municipalidad.entities.BitacoraCambios;
import org.una.municipalidad.entities.Cobros;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface BitacoraRepository extends JpaRepository<BitacoraCambios, Long> {
    public Optional<BitacoraCambios> findByBitacoraTabla(String bitacoraTabla);
    public Optional<BitacoraCambios> findByBitacoraDescripcion(String bitacoraDescripcion);
    @Query(value = "SELECT u FROM BitacoraCambios u JOIN u.usuario  c WHERE " +
            "  c.id=:idUsuario AND u.bitacoraFecha >= :startDate AND u.bitacoraFecha <= :endDate")
    public List<BitacoraCambios> findByIdBetweenFecha(@Param("idUsuario")Long id, @Param("startDate") Date startDate,
                                                                          @Param("endDate")Date endDate);
    @Query(value = "SELECT u FROM BitacoraCambios u WHERE u.bitacoraFecha >= :startDate AND u.bitacoraFecha <= :endDate")
    public List<BitacoraCambios> findByBitacoraCambiosBetweenFecha(@Param("startDate")Date startDate, @Param("endDate")Date endDate);

    @Query(value = "SELECT u FROM BitacoraCambios u JOIN u.usuario  c WHERE " +
            "  c.id=:idUsuario")
    public Optional<BitacoraCambios> findByIdUsuario(@Param("idUsuario")Long id);
}

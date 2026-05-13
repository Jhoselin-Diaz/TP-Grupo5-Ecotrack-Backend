package org.example.tpgrupo5ecotrackbackend.Repository;


import org.example.tpgrupo5ecotrackbackend.Entity.Consumo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import java.time.LocalDateTime;
import java.util.List;


public interface ConsumoRepository extends JpaRepository<Consumo, Long> {


    List<Consumo> findByUsuario_IdUsuarioAndFechaRegistroBetween(
            Long usuarioId,
            LocalDateTime inicio,
            LocalDateTime fin
    );


    @Query("SELECT COALESCE(SUM(c.emisionesKgCO2),0) FROM Consumo c")
    Double obtenerHuellaTotal();


    @Query("""
   SELECT c.categoria.nombreCategoria,
          SUM(c.emisionesKgCO2)
   FROM Consumo c
   GROUP BY c.categoria.nombreCategoria
   """)
    List<Object[]> obtenerHuellaPorCategoria();


    @Query("""
   SELECT u.idUsuario, u.username, u.correo,
   COUNT(c.id),
   MAX(c.fechaRegistro)
   FROM Consumo c
   JOIN c.usuario u
   GROUP BY u.idUsuario, u.username, u.correo
   ORDER BY COUNT(c.id) DESC
   """)
    List<Object[]> obtenerUsuariosMasActivos();


    @Query("""
   SELECT u.idUsuario, u.username, u.correo,
   SUM(c.emisionesKgCO2)
   FROM Consumo c
   JOIN c.usuario u
   GROUP BY u.idUsuario, u.username, u.correo
   ORDER BY SUM(c.emisionesKgCO2) DESC
   """)
    List<Object[]> obtenerUsuariosMayorHuella();


    @Query("""
       SELECT
           YEAR(c.fechaRegistro),
           MONTH(c.fechaRegistro),
           SUM(c.emisionesKgCO2)
       FROM Consumo c
       GROUP BY YEAR(c.fechaRegistro), MONTH(c.fechaRegistro)
       ORDER BY YEAR(c.fechaRegistro), MONTH(c.fechaRegistro)
   """)
    List<Object[]> obtenerEvolucionHuella();


    @Query("""
   SELECT c.categoria.nombreCategoria,
          SUM(c.cantidad * f.factorKgCO2PorUnidad)
   FROM Consumo c
   JOIN c.factor f
   WHERE c.usuario.idUsuario = :usuarioId
   GROUP BY c.categoria.nombreCategoria
""")
    List<Object[]> obtenerHuellaPorCategoriaUsuario(
            @Param("usuarioId") Long usuarioId);


}

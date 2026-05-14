package org.example.tpgrupo5ecotrackbackend.Repository;

import org.example.tpgrupo5ecotrackbackend.Entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Optional<Usuario> findByCorreo(String correo);

    Optional<Usuario> findByUsername(String username);

    Optional<Usuario> findById(Long id);

    long count();

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO usuario_roles (usuario_id, role_id ) " +
            "VALUES (:usuario_id, :role_id)", nativeQuery = true)
    public Integer insertUserRol(
            @Param("usuario_id") Long usuario_id,
            @Param("role_id") Long role_id);
}

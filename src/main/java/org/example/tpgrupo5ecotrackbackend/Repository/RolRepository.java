package org.example.tpgrupo5ecotrackbackend.Repository;

import org.example.tpgrupo5ecotrackbackend.Entity.Rol;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RolRepository extends JpaRepository<Rol, Long> {
    Optional<Rol> findByName(String name);


}

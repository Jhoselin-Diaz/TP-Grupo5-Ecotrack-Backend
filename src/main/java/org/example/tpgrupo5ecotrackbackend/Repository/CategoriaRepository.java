package org.example.tpgrupo5ecotrackbackend.Repository;

import org.example.tpgrupo5ecotrackbackend.Entity.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

    boolean existsByNombreCategoria(String nombreCategoria);
}

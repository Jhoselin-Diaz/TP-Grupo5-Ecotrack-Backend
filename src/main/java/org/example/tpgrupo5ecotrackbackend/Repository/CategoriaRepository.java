package org.example.tpgrupo5ecotrackbackend.Repository;

import org.example.tpgrupo5ecotrackbackend.Entity.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}

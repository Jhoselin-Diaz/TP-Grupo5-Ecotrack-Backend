package org.example.tpgrupo5ecotrackbackend.Repository;

import org.example.tpgrupo5ecotrackbackend.Entity.Categoria;
import org.example.tpgrupo5ecotrackbackend.Entity.FactorEmision;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FactorEmisionRepository extends JpaRepository<FactorEmision, Long> {

    List<FactorEmision> findByCategoria(Categoria categoria);

}
package org.example.tpgrupo5ecotrackbackend.Repository;

import org.example.tpgrupo5ecotrackbackend.Entity.FactorEmision;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FactorEmisionRepository extends JpaRepository<FactorEmision, Long> {

}
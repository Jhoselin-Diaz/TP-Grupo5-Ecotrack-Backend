package org.example.tpgrupo5ecotrackbackend.Service;

import org.example.tpgrupo5ecotrackbackend.Entity.Categoria;
import org.example.tpgrupo5ecotrackbackend.Entity.FactorEmision;
import org.example.tpgrupo5ecotrackbackend.Repository.CategoriaRepository;
import org.example.tpgrupo5ecotrackbackend.Repository.FactorEmisionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FactorEmisionService {

    @Autowired
    private FactorEmisionRepository factorEmisionRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    public List<FactorEmision> obtenerPorCategoria(Long idCategoria) {

        Categoria categoria = categoriaRepository.findById(idCategoria)
                .orElseThrow(() -> new RuntimeException("Categoria no encontrada"));

        return factorEmisionRepository.findByCategoria(categoria);
    }
}

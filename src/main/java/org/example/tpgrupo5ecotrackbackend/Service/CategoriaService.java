package org.example.tpgrupo5ecotrackbackend.Service;

import org.example.tpgrupo5ecotrackbackend.Entity.Categoria;
import org.example.tpgrupo5ecotrackbackend.Repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public List<Categoria> listarCategorias() {

        return categoriaRepository.findAll();
    }
}

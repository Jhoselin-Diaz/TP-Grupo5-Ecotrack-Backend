package org.example.tpgrupo5ecotrackbackend.Service;

import lombok.RequiredArgsConstructor;
import org.example.tpgrupo5ecotrackbackend.Entity.Categoria;
import org.example.tpgrupo5ecotrackbackend.Repository.CategoriaRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoriaService {

    private final CategoriaRepository categoriaRepository;

    public Categoria registrar(Categoria categoria) {

        if (categoriaRepository.existsByNombreCategoria(categoria.getNombreCategoria())) {
            throw new RuntimeException("La categoría ya existe");
        }
        return categoriaRepository.save(categoria);
    }
}

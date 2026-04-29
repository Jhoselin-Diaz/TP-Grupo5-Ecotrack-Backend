package org.example.tpgrupo5ecotrackbackend.Controller;

import lombok.RequiredArgsConstructor;
import org.example.tpgrupo5ecotrackbackend.Entity.Categoria;
import org.example.tpgrupo5ecotrackbackend.Service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categoria")
@RequiredArgsConstructor
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping("/listar")
    public List<Categoria> listar() {
        return categoriaService.listarCategorias();
    }
}
package org.example.tpgrupo5ecotrackbackend.Controller;

import lombok.RequiredArgsConstructor;
import org.example.tpgrupo5ecotrackbackend.Entity.FactorEmision;
import org.example.tpgrupo5ecotrackbackend.Service.FactorEmisionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/factores")
@RequiredArgsConstructor
public class FactorEmisionController {


    private final FactorEmisionService service;

    @GetMapping("/categoria/{categoriaId}")
    public List<FactorEmision> listarPorCategoria(@PathVariable Long categoriaId) {
        return service.obtenerPorCategoria(categoriaId);
    }
}
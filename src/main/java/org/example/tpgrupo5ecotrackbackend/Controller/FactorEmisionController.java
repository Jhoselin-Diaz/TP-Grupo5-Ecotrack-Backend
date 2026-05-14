package org.example.tpgrupo5ecotrackbackend.Controller;

import lombok.RequiredArgsConstructor;
import org.example.tpgrupo5ecotrackbackend.Entity.FactorEmision;
import org.example.tpgrupo5ecotrackbackend.Service.FactorEmisionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/factores")
@RequiredArgsConstructor
@CrossOrigin(origins = {"http://localhost:9876", "http://localhost:4200"})
public class FactorEmisionController {


    private final FactorEmisionService service;

    @GetMapping("/categoria/{categoriaId}")
    public List<FactorEmision> listarPorCategoria(@PathVariable Long categoriaId) {
        return service.obtenerPorCategoria(categoriaId);
    }
}
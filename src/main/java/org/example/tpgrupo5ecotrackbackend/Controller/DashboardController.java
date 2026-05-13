package org.example.tpgrupo5ecotrackbackend.Controller;

import lombok.RequiredArgsConstructor;
import org.example.tpgrupo5ecotrackbackend.DTO.*;
import org.example.tpgrupo5ecotrackbackend.Service.DashboardService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/dashboard")
@RequiredArgsConstructor
@CrossOrigin(origins = {"http://localhost:9876/", "http://localhost:4200"})
public class DashboardController {

    private final DashboardService dashboardService;

    @GetMapping("/resumen/simple")
    public DashboardResumenDTO obtenerResumenDashboard() {

        return dashboardService.obtenerResumenDashboard();
    }

    @GetMapping("/huella/categorias")
    public List<CategoriaHuellaDTO> obtenerHuellaPorCategoria() {

        return dashboardService.obtenerHuellaPorCategoria();
    }

    @GetMapping("/usuarios/activos")
    public List<UsuarioActivoDTO> obtenerUsuariosMasActivos() {

        return dashboardService.obtenerUsuariosMasActivos();
    }

    @GetMapping("/usuarios/mayorhuella")
    public List<UsuarioHuellaTotalDTO> obtenerUsuariosMayorHuella() {

        return dashboardService.obtenerUsuariosMayorHuella();
    }

    @GetMapping("/huella/evolucion")
    public List<EvolucionHuellaDTO> obtenerEvolucionHuella() {

        return dashboardService.obtenerEvolucionHuella();
    }
}
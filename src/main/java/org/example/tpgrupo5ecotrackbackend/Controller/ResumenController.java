package org.example.tpgrupo5ecotrackbackend.Controller;


import lombok.RequiredArgsConstructor;
import org.example.tpgrupo5ecotrackbackend.Service.*;
import org.example.tpgrupo5ecotrackbackend.DTO.*;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.YearMonth;
import java.util.List;

@RestController
@RequestMapping("/resumen")
@RequiredArgsConstructor
@CrossOrigin(origins = {"http://localhost:9876/", "http://localhost:4200"})
public class ResumenController {

    private final ResumenService resumenService;

    @GetMapping("/obtener/{usuarioId}/{periodo}")
    public ResumenDTO obtenerResumen(
            @PathVariable Long usuarioId,

            @PathVariable
            @DateTimeFormat(pattern = "yyyy-MM")
            YearMonth periodo
    ) {
        return resumenService.obtenerResumen(usuarioId, periodo);
    }

    @GetMapping("/reporte/admin/{id}")
    public ReportexUsuarioDTO obtenerReportePorUsuario(
            @PathVariable Long id
    ) {
        return resumenService.obtenerReporteUsuario(id);
    }

    @GetMapping("/categorias/{usuarioId}")
    public List<CategoriaHuellaDTO> obtenerHuellaPorCategoriaUsuario(
            @PathVariable Long usuarioId) {

        return resumenService.obtenerHuellaPorCategoriaUsuario(usuarioId);
    }

}

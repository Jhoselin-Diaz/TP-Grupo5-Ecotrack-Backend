package org.example.tpgrupo5ecotrackbackend.Controller;

import org.example.tpgrupo5ecotrackbackend.DTO.ConsumoDTO;
import org.example.tpgrupo5ecotrackbackend.Entity.Consumo;
import org.example.tpgrupo5ecotrackbackend.Service.ConsumoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/consumos")
@RequiredArgsConstructor
public class ConsumoController {

    private final ConsumoService consumoService;


    @PostMapping("/registrar")
    public Consumo registrar(@RequestBody ConsumoDTO dto) {
        return consumoService.registrar(dto);
    }
}
package org.example.tpgrupo5ecotrackbackend.Controller;

import org.example.tpgrupo5ecotrackbackend.DTO.ConsumoDTO;
import org.example.tpgrupo5ecotrackbackend.Entity.Consumo;
import org.example.tpgrupo5ecotrackbackend.Service.ConsumoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/consumos")
@RequiredArgsConstructor
@CrossOrigin(origins = {"http://localhost:9876", "http://localhost:4200"})
public class ConsumoController {

    private final ConsumoService consumoService;


    @PostMapping("/registrar")
    public Consumo registrar(@RequestBody ConsumoDTO dto) {
        return consumoService.registrar(dto);
    }

    @GetMapping("/listar")
    public List<Consumo> listar() {
        return consumoService.listar();
    }

    @PutMapping("/editar/{id}")
    public Consumo editar(@PathVariable Long id,
                          @RequestBody ConsumoDTO dto) {
        return consumoService.editar(id, dto);
    }

    @DeleteMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id) {
        consumoService.eliminar(id);
        return "Consumo eliminado correctamente";
    }

}
package org.example.tpgrupo5ecotrackbackend.Controller;

import org.example.tpgrupo5ecotrackbackend.DTO.UsuarioResponseDTO;
import org.example.tpgrupo5ecotrackbackend.DTO.UsuarioDTO;
import org.example.tpgrupo5ecotrackbackend.Service.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping("/lista")
    public List<UsuarioResponseDTO> listar() {
        return usuarioService.obtenerUsuarios();
    }

    @PostMapping("/inserta")
    public ResponseEntity<UsuarioResponseDTO> insertar(@RequestBody UsuarioDTO dto) {
        UsuarioResponseDTO usuario = usuarioService.insertar(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(usuario);
    }

    @PutMapping("/actualiza/{id}")
    public UsuarioResponseDTO actualizar(
            @PathVariable Long id,
            @RequestBody UsuarioDTO dto
    ) {
        return usuarioService.actualizar(id, dto);
    }

    @DeleteMapping("/elimina/{id}")
    public String eliminar(@PathVariable Long id) {
        return usuarioService.eliminar(id);
    }


}
package org.example.tpgrupo5ecotrackbackend.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioActivoDTO {

    private Long usuarioId;
    private String username;
    private String correo;
    private Long totalRegistros;
    private LocalDateTime ultimoRegistro;
}

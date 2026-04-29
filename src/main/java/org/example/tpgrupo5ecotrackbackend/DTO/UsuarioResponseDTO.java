package org.example.tpgrupo5ecotrackbackend.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioResponseDTO {
    private Long idUsuario;
    private String username;
    private String correo;
    private Boolean enabled;
    private String rol;
}

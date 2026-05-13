package org.example.tpgrupo5ecotrackbackend.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioHuellaTotalDTO {
    private Long usuarioId;
    private String username;
    private String correo;
    private Double totalKgCO2;
}

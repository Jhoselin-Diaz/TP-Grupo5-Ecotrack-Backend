package org.example.tpgrupo5ecotrackbackend.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ConsumoDTO {

    private Long usuarioId;
    private Long factorId;
    private Double cantidad;
    private String unidad;
    private List<ConsumoDetalleDTO> detalles;
}

package org.example.tpgrupo5ecotrackbackend.DTO;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ItemConsumoDTO {

    private String nombre;
    private Double emisiones;
    private String unidad;
    private Double cantidad;

}
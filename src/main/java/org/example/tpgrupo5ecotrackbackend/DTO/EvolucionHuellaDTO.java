package org.example.tpgrupo5ecotrackbackend.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EvolucionHuellaDTO {

    private Integer anio;
    private Integer mes;
    private Double totalKgCO2;
}
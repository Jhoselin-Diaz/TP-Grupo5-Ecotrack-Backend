package org.example.tpgrupo5ecotrackbackend.DTO;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EquivalenciaDTO {

    private Double arboles;
    private Double kmAuto;
    private Double mesesElectricidad;
}

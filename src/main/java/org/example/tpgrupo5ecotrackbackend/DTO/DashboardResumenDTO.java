package org.example.tpgrupo5ecotrackbackend.DTO;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DashboardResumenDTO {

    private Long totalUsuarios;
    private Long totalConsumos;
    private Double huellaTotal;
    private Double huellaPromedio;
}







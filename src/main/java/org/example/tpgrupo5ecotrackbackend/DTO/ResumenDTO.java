package org.example.tpgrupo5ecotrackbackend.DTO;

import lombok.Builder;
import lombok.Data;
import java.util.List;

@Data
@Builder
public class ResumenDTO {

    private Double totalGeneral;
    private String periodo;
    private List<CategoriaDTO> categorias;
    private EquivalenciaDTO equivalencias;
}

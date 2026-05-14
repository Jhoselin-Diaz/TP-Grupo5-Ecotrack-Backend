package org.example.tpgrupo5ecotrackbackend.DTO;

import lombok.Builder;
import lombok.Data;
import java.util.List;

@Data
@Builder
public class CategoriaDTO {

    private String nombre;
    private Double total;
    private List<ItemConsumoDTO> items;
}
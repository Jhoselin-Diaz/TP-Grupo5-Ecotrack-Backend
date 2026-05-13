package org.example.tpgrupo5ecotrackbackend.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReportexUsuarioDTO {

    private Long usuarioId;
    private String nombreUsuario;
    private String correo;
    private Double totalGeneral;
    private List<CategoriaDTO> categorias;
    private EquivalenciaDTO equivalencias;


}

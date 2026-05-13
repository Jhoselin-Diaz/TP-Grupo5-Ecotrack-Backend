package org.example.tpgrupo5ecotrackbackend.Service;


import lombok.RequiredArgsConstructor;
import org.example.tpgrupo5ecotrackbackend.DTO.*;
import org.example.tpgrupo5ecotrackbackend.Repository.ConsumoRepository;
import org.example.tpgrupo5ecotrackbackend.Repository.UsuarioRepository;
import org.springframework.stereotype.Service;


import java.time.LocalDateTime;
import java.util.List;


@Service
@RequiredArgsConstructor
public class DashboardService {


   private final UsuarioRepository usuarioRepository;
   private final ConsumoRepository consumoRepository;


   public DashboardResumenDTO obtenerResumenDashboard() {


       long totalUsuarios = usuarioRepository.count();
       long totalConsumos = consumoRepository.count();


       Double huellaTotal = consumoRepository.obtenerHuellaTotal();


       Double huellaPromedio = 0.0;


       if (totalUsuarios > 0) {
           huellaPromedio = huellaTotal / totalUsuarios;
       }


       return DashboardResumenDTO.builder()
               .totalUsuarios(totalUsuarios)
               .totalConsumos(totalConsumos)
               .huellaTotal(huellaTotal)
               .huellaPromedio(huellaPromedio)
               .build();
   }


   public List<CategoriaHuellaDTO> obtenerHuellaPorCategoria() {


       List<Object[]> resultados = consumoRepository.obtenerHuellaPorCategoria();


       double totalGlobal = resultados.stream()
               .mapToDouble(r -> ((Number) r[1]).doubleValue())
               .sum();


       return resultados.stream()
               .map(r -> {


                   String categoria = (String) r[0];
                   double total = ((Number) r[1]).doubleValue();


                   double porcentaje = totalGlobal > 0
                           ? (total * 100) / totalGlobal
                           : 0;


                   return CategoriaHuellaDTO.builder()
                           .categoria(categoria)
                           .totalKgCO2(total)
                           .porcentaje(porcentaje)
                           .build();
               })
               .sorted((a, b) -> Double.compare(b.getTotalKgCO2(), a.getTotalKgCO2()))
               .toList();
   }


   public List<UsuarioActivoDTO> obtenerUsuariosMasActivos() {


       List<Object[]> resultados = consumoRepository.obtenerUsuariosMasActivos();


       return resultados.stream()
               .map(r -> UsuarioActivoDTO.builder()


                       .usuarioId(((Number) r[0]).longValue())
                       .username((String) r[1])
                       .correo((String) r[2])
                       .totalRegistros(((Number) r[3]).longValue())
                       .ultimoRegistro((LocalDateTime) r[4])


                       .build()
               )
               .toList();
   }


   public List<UsuarioHuellaTotalDTO> obtenerUsuariosMayorHuella() {


       List<Object[]> resultados = consumoRepository.obtenerUsuariosMayorHuella();


       return resultados.stream()
               .map(r -> UsuarioHuellaTotalDTO.builder()


                       .usuarioId(((Number) r[0]).longValue())
                       .username((String) r[1])
                       .correo((String) r[2])
                       .totalKgCO2(((Number) r[3]).doubleValue())


                       .build()
               )
               .toList();
   }


   public List<EvolucionHuellaDTO> obtenerEvolucionHuella() {


       List<Object[]> resultados = consumoRepository.obtenerEvolucionHuella();


       return resultados.stream()
               .map(r -> EvolucionHuellaDTO.builder()


                       .anio(((Number) r[0]).intValue())
                       .mes(((Number) r[1]).intValue())
                       .totalKgCO2(((Number) r[2]).doubleValue())


                       .build()
               )
               .toList();
   }
}

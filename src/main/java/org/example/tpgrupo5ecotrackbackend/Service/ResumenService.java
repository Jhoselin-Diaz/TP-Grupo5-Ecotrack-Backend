package org.example.tpgrupo5ecotrackbackend.Service;

import lombok.RequiredArgsConstructor;
import org.example.tpgrupo5ecotrackbackend.Entity.*;
import org.example.tpgrupo5ecotrackbackend.Repository.*;
import org.example.tpgrupo5ecotrackbackend.DTO.*;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.YearMonth;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ResumenService {

    private final ConsumoRepository consumoRepository;
    private final UsuarioRepository usuarioRepository;

    public ResumenDTO obtenerResumen(Long usuarioId, YearMonth periodo) {

        List<Consumo> consumos = obtenerConsumos(usuarioId, periodo);

        double total = calcularTotal(consumos);

        List<CategoriaDTO> categorias = mapearCategoriasConItems(consumos);

        EquivalenciaDTO eq = calcularEquivalencias(total);

        return ResumenDTO.builder()
                .totalGeneral(total)
                .categorias(categorias)
                .equivalencias(eq)
                .build();
    }



    private List<Consumo> obtenerConsumos(Long usuarioId, YearMonth periodo) {

        LocalDateTime inicio = periodo.atDay(1).atStartOfDay();
        LocalDateTime fin = periodo.atEndOfMonth().atTime(23, 59, 59);

        return consumoRepository.findByUsuario_IdUsuarioAndFechaRegistroBetween(usuarioId, inicio, fin);
    }

    private double calcularTotal(List<Consumo> consumos) {
        return consumos.stream()
                .mapToDouble(Consumo::getEmisionesKgCO2)
                .sum();
    }

    private List<CategoriaDTO> mapearCategoriasConItems(List<Consumo> consumos) {

        return consumos.stream()
                .collect(Collectors.groupingBy(c ->
                        c.getCategoria() != null
                                ? c.getCategoria().getNombreCategoria()
                                : "Sin categorÃ­a"
                ))
                .entrySet()
                .stream()
                .map(entry -> {

                    List<Consumo> lista = entry.getValue();

                    return CategoriaDTO.builder()
                            .nombre(entry.getKey())
                            .total(lista.stream()
                                    .mapToDouble(Consumo::getEmisionesKgCO2)
                                    .sum())
                            .items(lista.stream()
                                    .map(c -> ItemConsumoDTO.builder()
                                            .nombre(c.getNombre())
                                            .emisiones(c.getEmisionesKgCO2())
                                            .cantidad(c.getCantidad())
                                            .unidad(c.getUnidad())
                                            .build()
                                    ).toList())
                            .build();
                })
                .sorted((a, b) -> Double.compare(b.getTotal(), a.getTotal()))
                .toList();
    }

    private EquivalenciaDTO calcularEquivalencias(double total) {

        return EquivalenciaDTO.builder()
                .arboles(total / 21.0)
                .kmAuto(total * 4.5)
                .mesesElectricidad(total / 30.0)
                .build();
    }

    public ReportexUsuarioDTO obtenerReporteUsuario(Long usuarioId) {

        Usuario usuario = usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        YearMonth periodoActual = YearMonth.now();

        ResumenDTO resumen = obtenerResumen(usuarioId, periodoActual);

        return ReportexUsuarioDTO.builder()
                .usuarioId(usuario.getIdUsuario())
                .nombreUsuario(usuario.getUsername())
                .correo(usuario.getCorreo())
                .totalGeneral(resumen.getTotalGeneral())
                .categorias(resumen.getCategorias())
                .equivalencias(resumen.getEquivalencias())
                .build();
    }

    public List<CategoriaHuellaDTO> obtenerHuellaPorCategoriaUsuario(Long usuarioId) {

        List<Object[]> resultados =
                consumoRepository.obtenerHuellaPorCategoriaUsuario(usuarioId);

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
                .sorted((a, b) ->
                        Double.compare(b.getTotalKgCO2(), a.getTotalKgCO2()))
                .toList();
    }


}

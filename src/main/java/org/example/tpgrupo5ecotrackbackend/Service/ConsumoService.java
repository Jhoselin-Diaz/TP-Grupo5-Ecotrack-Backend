package org.example.tpgrupo5ecotrackbackend.Service;

import org.example.tpgrupo5ecotrackbackend.DTO.ConsumoDTO;
import org.example.tpgrupo5ecotrackbackend.Entity.*;
import org.example.tpgrupo5ecotrackbackend.Repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ConsumoService {

    private final ConsumoRepository consumoRepository;
    private final CategoriaRepository categoriaRepository;
    private final FactorEmisionRepository factorRepository;
    private final UsuarioRepository usuarioRepository;

    public Consumo registrar(ConsumoDTO dto) {

        Usuario usuario = usuarioRepository.findById(dto.getUsuarioId())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        FactorEmision factor = factorRepository.findById(dto.getFactorId())
                .orElseThrow(() -> new RuntimeException("Factor no encontrado"));

        // Validación de unidad
        if (dto.getUnidad() != null &&
                !factor.getUnidad().equalsIgnoreCase(dto.getUnidad())) {
            throw new RuntimeException("Unidad incorrecta. Se esperaba: " + factor.getUnidad());
        }

        Categoria categoria = factor.getCategoria();

        Consumo consumo = Consumo.builder()
                .usuario(usuario)
                .factor(factor)
                .categoria(categoria)
                .nombre(factor.getNombre())
                .cantidad(dto.getCantidad())
                .unidad(factor.getUnidad())
                .fechaRegistro(LocalDateTime.now())
                .build();

        if (dto.getDetalles() != null && !dto.getDetalles().isEmpty()) {

            List<ConsumoDetalle> detalles = dto.getDetalles().stream().map(d -> {
                ConsumoDetalle detalle = new ConsumoDetalle();
                detalle.setClave(d.getClave());
                detalle.setValor(d.getValor());
                detalle.setConsumo(consumo);
                return detalle;
            }).toList();

            consumo.setDetalles(detalles);
        }

        return consumoRepository.save(consumo);

  }}
package org.example.tpgrupo5ecotrackbackend.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "consumo_detalle")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ConsumoDetalle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDetalle;

    private String clave; // "marca", "tipo_gasolina"
    private String valor; // "Toyota", "Diesel"

    @ManyToOne
    @JoinColumn(name = "consumo_id")
    @JsonBackReference
    private Consumo consumo;
}
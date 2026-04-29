package org.example.tpgrupo5ecotrackbackend.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "factores_emision")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FactorEmision {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFactor;


    @Column(nullable = false, unique = true)
    private String codigo;
    private String nombre;
    private String keyword;
    private String unidad;
    private Float factorKgCO2PorUnidad;

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;
}

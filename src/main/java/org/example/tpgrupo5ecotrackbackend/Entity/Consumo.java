package org.example.tpgrupo5ecotrackbackend.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table (name = "consumos")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Consumo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private Double cantidad;
    private String unidad;
    private Double emisionesKgCO2;
    private LocalDateTime fechaRegistro;

    @ManyToOne
    @JoinColumn (name= "usuario_id")
    @JsonBackReference
    private Usuario usuario;

    @ManyToOne
    @JoinColumn (name = "categoria_id")
    private Categoria categoria;

    @ManyToOne
    @JoinColumn (name = "factor_id")
    private FactorEmision factor;

    @OneToMany (mappedBy = "consumo", cascade = CascadeType.ALL)
    @JsonBackReference
    private List<ConsumoDetalle> detalles;

    public void calcularEmisiones (){
        if(this.factor != null && this.cantidad != null) {
            this.emisionesKgCO2 = this.cantidad * this.factor.getFactorKgCO2PorUnidad();
        }
    }
}

package org.example.tpgrupo5ecotrackbackend.Entity;

import jakarta.persistence.Table;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Contract;

import java.time.LocalDateTime;
import java.time.YearMonth;
import java.util.List;

@Entity
@Table(name = "huellas_carbono")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class HuellaCarbono {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idHuella;

    private String periodo;
    private LocalDateTime fechaCalculo;
    private Float totalKgCO2;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;


}

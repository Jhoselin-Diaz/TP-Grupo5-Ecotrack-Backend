package org.example.tpgrupo5ecotrackbackend.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;


@Entity
@Data
@Table (name = "Usuario")
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUsuario;

    @Column(nullable = false, length = 50)
    private String username;

    @Column(nullable = false, unique = true, length = 50)
    private String correo;

    @Column(nullable = false, length = 200)
    @JsonIgnore
    private String password;

    private Boolean enabled = true;


    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    private List<SubCategoriaAlimento> alimentos;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    private List<SubCategoriaElectrodomestico> electrodomestico;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    private List<SubCategoriaRopa> ropas;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    private List<SubCategoriaCoche> coches;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    private List<SubCategoriaAutobus> autobuses;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    private List<SubCategoriaServicioVivienda> serviciosViviendas;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    private List<HuellaCarbono> huellas;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    private List<Resultado> resultado;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "usuario_roles",
            joinColumns = @JoinColumn(name = "usuario_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private List<Rol> roles;

}

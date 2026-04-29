package org.example.tpgrupo5ecotrackbackend.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioDTO {
    private String username;
    private String correo;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;
}


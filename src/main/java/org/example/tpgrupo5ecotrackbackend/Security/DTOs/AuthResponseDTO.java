package org.example.tpgrupo5ecotrackbackend.Security.DTOs;

import java.util.Set;

@lombok.Data
public class AuthResponseDTO {
    private String jwt;
    private Set<String> roles;
}
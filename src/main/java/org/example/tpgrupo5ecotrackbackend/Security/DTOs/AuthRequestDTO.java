package org.example.tpgrupo5ecotrackbackend.Security.DTOs;

public class AuthRequestDTO {
    private String username;
    private String password;
    // getters and setters

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
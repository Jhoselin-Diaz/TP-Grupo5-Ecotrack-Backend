package org.example.tpgrupo5ecotrackbackend.Service;


import org.example.tpgrupo5ecotrackbackend.DTO.UsuarioResponseDTO;
import org.example.tpgrupo5ecotrackbackend.DTO.UsuarioDTO;
import org.example.tpgrupo5ecotrackbackend.Entity.Rol;
import org.example.tpgrupo5ecotrackbackend.Entity.Usuario;
import org.example.tpgrupo5ecotrackbackend.Repository.RolRepository;
import org.example.tpgrupo5ecotrackbackend.Repository.UsuarioRepository;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
@Slf4j
public class UsuarioService {

    @Autowired
    private  UsuarioRepository usuarioRepository;

    @Autowired
    private  RolRepository rolRepository;

    @Autowired
    private ModelMapper modelMapper;


    public List<UsuarioResponseDTO> obtenerUsuarios() {
        return usuarioRepository.findAll()
                .stream()
                .map(usuario -> {
                    UsuarioResponseDTO dto = modelMapper.map(usuario, UsuarioResponseDTO.class);
                    dto.setRol(
                            usuario.getRoles()
                                    .stream()
                                    .map(Rol::getName)
                                    .collect(java.util.stream.Collectors.joining(", "))
                    );
                    return dto;
                })
                .toList();
    }

    public UsuarioResponseDTO insertar(UsuarioDTO usuarioDTO) {

        log.info("Insertando nuevo usuario: {}", usuarioDTO.getUsername());
        if (usuarioRepository.findByCorreo(usuarioDTO.getCorreo()).isPresent()) {
            throw new RuntimeException("El correo ya está registrado");
        }

        Rol rolUser = rolRepository.findByName("USER")
                .orElseThrow(() -> new RuntimeException("Rol USER no encontrado"));
        Usuario usuario = modelMapper.map(usuarioDTO, Usuario.class);
        usuario.setRoles(List.of(rolUser));

        Usuario usuarioGuardado = usuarioRepository.save(usuario);
        return modelMapper.map(usuarioGuardado, UsuarioResponseDTO.class);
    }

    public UsuarioResponseDTO actualizar(Long id, UsuarioDTO dto) {

        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        if (!usuario.getCorreo().equals(dto.getCorreo())) {
            if (usuarioRepository.findByCorreo(dto.getCorreo()).isPresent()) {
                throw new RuntimeException("El correo ya está registrado");
            }
            usuario.setCorreo(dto.getCorreo());
        }

        usuario.setUsername(dto.getUsername());

        if (dto.getPassword() != null && !dto.getPassword().isEmpty()) {
            usuario.setPassword(dto.getPassword());
        }

        Usuario actualizado = usuarioRepository.save(usuario);

        return modelMapper.map(actualizado, UsuarioResponseDTO.class);
    }

    public String eliminar(Long id) {
        log.warn("Eliminando usuario con ID: {}", id);
        usuarioRepository.deleteById(id);
        return "Registro eliminado";
    }
}
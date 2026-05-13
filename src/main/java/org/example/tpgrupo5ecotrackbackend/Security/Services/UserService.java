package org.example.tpgrupo5ecotrackbackend.Security.Services;

import org.example.tpgrupo5ecotrackbackend.Entity.*;
import org.example.tpgrupo5ecotrackbackend.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {
    @Autowired
    private UsuarioRepository userRepository;
    @Autowired
    private RolRepository roleRepository;

    @Transactional
    public void save(Usuario user) {

        userRepository.save(user);
    }

    @Transactional
    public void grabar(Rol role) {

        roleRepository.save(role);
    }

    public Integer insertUserRol(Long usuario_id, Long role_id) {
        Integer result = 0;
        userRepository.insertUserRol(usuario_id, role_id);
        return 1;
    }

}
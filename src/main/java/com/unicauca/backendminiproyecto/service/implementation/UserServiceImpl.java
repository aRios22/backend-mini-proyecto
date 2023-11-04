package com.unicauca.backendminiproyecto.service.implementation;

import org.springframework.stereotype.Service;

import com.unicauca.backendminiproyecto.domain.Usuario;
import com.unicauca.backendminiproyecto.dto.request.LoginRequest;
import com.unicauca.backendminiproyecto.dto.response.LoginResponse;
import com.unicauca.backendminiproyecto.mapper.LoginMapper;
import com.unicauca.backendminiproyecto.repository.UserRepository;
import com.unicauca.backendminiproyecto.service.interfaz.UserService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService{

    private UserRepository userRepository;

    @Override
    public LoginResponse logIn(LoginRequest loginRequest) {
        Usuario response = userRepository.findByUsuarioAndClave(loginRequest.getUsuario(), loginRequest.getClave());
        if(response==null){
           return null;
        }
        return LoginMapper.mapearResponse(response);
    }
    
}

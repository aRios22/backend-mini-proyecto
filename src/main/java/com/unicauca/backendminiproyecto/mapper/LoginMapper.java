package com.unicauca.backendminiproyecto.mapper;

import com.unicauca.backendminiproyecto.Commons.Constants;
import com.unicauca.backendminiproyecto.domain.Usuario;
import com.unicauca.backendminiproyecto.dto.response.LoginResponse;

public final class LoginMapper {
    
    private LoginMapper() {
        throw new IllegalStateException(Constants.UTILITY_CLASS);
    }

    public static LoginResponse mapearResponse(Usuario usuario) {
        return LoginResponse.builder()
        .nombre(usuario.getNombre())
        .usuario(usuario.getUsuario())
        .build();
    }
}
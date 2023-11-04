package com.unicauca.backendminiproyecto.service.interfaz;

import com.unicauca.backendminiproyecto.dto.request.LoginRequest;
import com.unicauca.backendminiproyecto.dto.response.LoginResponse;

public interface UserService {

    LoginResponse logIn(LoginRequest loginRequest);
}

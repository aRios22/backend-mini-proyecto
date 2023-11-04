package com.unicauca.backendminiproyecto.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LoginResponse {
    private String nombre;
    private String correo;
    private String usuario;

}
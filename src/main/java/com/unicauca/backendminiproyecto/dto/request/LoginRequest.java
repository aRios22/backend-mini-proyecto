package com.unicauca.backendminiproyecto.dto.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LoginRequest {
    private String usuario;
    private String clave;
}
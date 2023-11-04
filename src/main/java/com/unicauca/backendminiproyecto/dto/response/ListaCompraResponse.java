package com.unicauca.backendminiproyecto.dto.response;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ListaCompraResponse {

    private String nombre;
    private LocalDateTime fecha;
    
}

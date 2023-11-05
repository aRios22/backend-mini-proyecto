package com.unicauca.backendminiproyecto.dto.response;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ListaCompraProductosResponse {

    private String nombre;
    private int precio;
    private String estado;
    private LocalDateTime fecha;
    private String nombreProveedor;

    
}

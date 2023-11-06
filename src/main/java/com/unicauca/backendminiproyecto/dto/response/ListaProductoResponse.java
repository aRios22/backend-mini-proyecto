package com.unicauca.backendminiproyecto.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ListaProductoResponse {
    private String estado;
    private String nombreLista;
    private String nombreProducto;
}

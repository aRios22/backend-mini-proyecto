package com.unicauca.backendminiproyecto.dto.request;

import java.util.Date;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ListaCompraRequest {
    private String nombre;
    private Date fecha;
}

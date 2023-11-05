package com.unicauca.backendminiproyecto.service.interfaz;

import java.util.List;

import com.unicauca.backendminiproyecto.dto.response.ProductoNombreResponse;

public interface ProductoService {

    List<ProductoNombreResponse> findAll();
    
}

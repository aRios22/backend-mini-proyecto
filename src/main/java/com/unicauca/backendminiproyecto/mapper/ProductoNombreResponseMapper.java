package com.unicauca.backendminiproyecto.mapper;

import com.unicauca.backendminiproyecto.Commons.Constants;
import com.unicauca.backendminiproyecto.domain.Producto;
import com.unicauca.backendminiproyecto.dto.response.ProductoNombreResponse;

public final class ProductoNombreResponseMapper {
    private ProductoNombreResponseMapper() {
        throw new IllegalStateException(Constants.UTILITY_CLASS);
    }

    public static ProductoNombreResponse mapearResponse(Producto producto) {
        return ProductoNombreResponse.builder()
        .nombre(producto.getNombre())
        .build();
    }
}

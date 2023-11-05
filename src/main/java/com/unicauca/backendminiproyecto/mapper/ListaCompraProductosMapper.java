package com.unicauca.backendminiproyecto.mapper;

import com.unicauca.backendminiproyecto.Commons.Constants;
import com.unicauca.backendminiproyecto.domain.ListaProducto;
import com.unicauca.backendminiproyecto.domain.Producto;
import com.unicauca.backendminiproyecto.dto.response.ListaCompraProductosResponse;

public final class ListaCompraProductosMapper {
    
    private ListaCompraProductosMapper() {
        throw new IllegalStateException(Constants.UTILITY_CLASS);
    }

    public static ListaCompraProductosResponse mapearResponse(Producto producto, ListaProducto lista) {
        return ListaCompraProductosResponse.builder()
        .nombre(producto.getNombre())
        .precio(producto.getPrecio())
        .fecha(producto.getFechaHoraAprobacion())
        .estado(lista.getEstado())
        .nombreProveedor(producto.getProveedor().getNombre())
        .build();
    }

}

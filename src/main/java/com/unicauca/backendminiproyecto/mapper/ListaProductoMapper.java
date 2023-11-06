package com.unicauca.backendminiproyecto.mapper;

import com.unicauca.backendminiproyecto.Commons.Constants;
import com.unicauca.backendminiproyecto.domain.ListaCompras;
import com.unicauca.backendminiproyecto.domain.ListaProducto;
import com.unicauca.backendminiproyecto.domain.Producto;
import com.unicauca.backendminiproyecto.dto.response.ListaProductoResponse;

public final class ListaProductoMapper {

    private ListaProductoMapper() {
        throw new IllegalStateException(Constants.UTILITY_CLASS);
    }

    public static ListaProducto mapearRequestEntidad(Producto producto, ListaCompras listaComprasVar) {
        return ListaProducto.builder()
        .listas(listaComprasVar)
        .producto(producto)
        .estado("Pendiente")
        .build();
    }

    public static ListaProductoResponse mapearResponse(ListaProducto savedLista) {
        return ListaProductoResponse.builder()
        .estado(savedLista.getEstado())
        .nombreLista(savedLista.getListas().getNombre())
        .nombreProducto(savedLista.getProducto().getNombre())
        .build();
    }

    
    
}

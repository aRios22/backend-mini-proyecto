package com.unicauca.backendminiproyecto.mapper;

import java.time.LocalDateTime;

import com.unicauca.backendminiproyecto.Commons.Constants;
import com.unicauca.backendminiproyecto.domain.ListaCompras;
import com.unicauca.backendminiproyecto.domain.Usuario;
import com.unicauca.backendminiproyecto.dto.request.ListaCompraRequest;
import com.unicauca.backendminiproyecto.dto.response.ListaCompraResponse;

public final class ListaCompraMapper {

    private ListaCompraMapper() {
        throw new IllegalStateException(Constants.UTILITY_CLASS);
    }

    public static ListaCompraResponse mapearResponse(ListaCompras lista) {
        return ListaCompraResponse.builder()
        .nombre(lista.getNombre())
        .fecha(lista.getFecha())
        .build();
    }

    public static ListaCompras mapearRequestEntidad(ListaCompraRequest lista, Usuario usuario) {
        LocalDateTime  date = LocalDateTime.now();
        return ListaCompras.builder()
                .nombre(lista.getNombre())
                .fecha(date)
                .usuario(usuario)
                .build();
    }
    
}

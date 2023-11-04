package com.unicauca.backendminiproyecto.service.interfaz;

import java.util.List;

import com.unicauca.backendminiproyecto.domain.ListaCompras;
import com.unicauca.backendminiproyecto.dto.request.ListaCompraRequest;
import com.unicauca.backendminiproyecto.dto.response.ListaCompraResponse;


public interface ListaCompraService {

    List<ListaCompraResponse> findAllUsuario(String usuario);

    ListaCompras findByNombre(String nombre, String username);

    ListaCompraResponse registrarLista(ListaCompraRequest listaRequest, String username);
    
}

package com.unicauca.backendminiproyecto.service.interfaz;

import com.unicauca.backendminiproyecto.domain.ListaCompras;
import com.unicauca.backendminiproyecto.dto.response.ListaProductoResponse;

public interface ListaProductoService {

    ListaProductoResponse registrarListaProducto(String listaProductoRequest, String username,
            ListaCompras listaComprasVar);

    Boolean eliminarListaProducto(String producto, String usuario, ListaCompras listaComprasVar);
    
}

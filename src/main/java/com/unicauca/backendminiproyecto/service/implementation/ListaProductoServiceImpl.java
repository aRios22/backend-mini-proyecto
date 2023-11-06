package com.unicauca.backendminiproyecto.service.implementation;

import org.springframework.stereotype.Service;

import com.unicauca.backendminiproyecto.domain.ListaCompras;
import com.unicauca.backendminiproyecto.domain.ListaProducto;
import com.unicauca.backendminiproyecto.domain.ListaProductoId;
import com.unicauca.backendminiproyecto.domain.Producto;
import com.unicauca.backendminiproyecto.dto.response.ListaProductoResponse;
import com.unicauca.backendminiproyecto.mapper.ListaProductoMapper;
import com.unicauca.backendminiproyecto.repository.ListaProductoRepository;
import com.unicauca.backendminiproyecto.repository.ProductoRepository;
import com.unicauca.backendminiproyecto.service.interfaz.ListaProductoService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class ListaProductoServiceImpl implements ListaProductoService{
    
    private ListaProductoRepository listaProductoRepository;
    private ProductoRepository productoRepository;

    @Override
    public ListaProductoResponse registrarListaProducto(String producto, String username, ListaCompras listaComprasVar) {

        Producto productoVar = this.productoRepository.findByNombre(producto);
        if (productoVar==null) {
            return null;
        }

        ListaProducto lista = ListaProductoMapper.mapearRequestEntidad(productoVar, listaComprasVar);
        ListaProductoId idListaProducto=new ListaProductoId(listaComprasVar.getId(), productoVar.getId());
        lista.setId(idListaProducto);

        ListaProducto savedLista = listaProductoRepository.save(lista);
        return ListaProductoMapper.mapearResponse(savedLista);
    }

    @Override
    public Boolean eliminarListaProducto(String producto, String usuario, ListaCompras listaComprasVar) {
        Producto productoVar = this.productoRepository.findByNombre(producto);
        if (productoVar==null) {
            return false;
        }
        ListaProductoId idListaProducto=new ListaProductoId(listaComprasVar.getId(), productoVar.getId());
        ListaProducto lista = this.listaProductoRepository.findById(idListaProducto).get();
        if(lista==null){
            return false;
        }
        listaProductoRepository.delete(lista);
        return true;
    }
    
}

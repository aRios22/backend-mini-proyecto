package com.unicauca.backendminiproyecto.service.implementation;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.unicauca.backendminiproyecto.domain.ListaCompras;
import com.unicauca.backendminiproyecto.domain.ListaProducto;
import com.unicauca.backendminiproyecto.domain.ListaProductoId;
import com.unicauca.backendminiproyecto.domain.Usuario;
import com.unicauca.backendminiproyecto.dto.request.ListaCompraRequest;
import com.unicauca.backendminiproyecto.dto.response.ListaCompraProductosResponse;
import com.unicauca.backendminiproyecto.dto.response.ListaCompraResponse;
import com.unicauca.backendminiproyecto.mapper.ListaCompraMapper;
import com.unicauca.backendminiproyecto.mapper.ListaCompraProductosMapper;
import com.unicauca.backendminiproyecto.repository.ListaComprasRepository;
import com.unicauca.backendminiproyecto.repository.ListaProductoRepository;
import com.unicauca.backendminiproyecto.repository.ProductoRepository;
import com.unicauca.backendminiproyecto.repository.UserRepository;
import com.unicauca.backendminiproyecto.service.interfaz.ListaCompraService;

import lombok.AllArgsConstructor;


@AllArgsConstructor
@Service
public class ListaCompraServiceImpl implements ListaCompraService{

    private UserRepository userRepository;
    private ListaComprasRepository listaComprasRepository;
    private ProductoRepository productoRepository;
    private ListaProductoRepository listaProductoRepository;

    @Override
    public List<ListaCompraResponse> findAllUsuario(String username) {
        Usuario usuario = this.userRepository.findByUsuario(username).orElseThrow(() -> new UsernameNotFoundException("El usuario no existe"));;
        Set<ListaCompras> listas=usuario.getListas();
        if(listas.size()==0){
            return null;
        }
        List<ListaCompraResponse> response = new ArrayList<ListaCompraResponse>();
        for(ListaCompras lista :listas) {
           response.add(ListaCompraMapper.mapearResponse(lista));
        }
        return response;
    }

    @Override
    public ListaCompras findByNombre(String nombre, String username) {
        Usuario usuario = this.userRepository.findByUsuario(username).orElseThrow(() -> new UsernameNotFoundException("El usuario no existe"));
        ListaCompras lista=this.listaComprasRepository.findByNombreAndUsuario(nombre, usuario);
        if (lista==null) {
            return null;
        }
        return lista;
    }

    @Override
    public ListaCompraResponse registrarLista(ListaCompraRequest listaRequest, String username) {
        Usuario usuario = this.userRepository.findByUsuario(username).orElseThrow(() -> new UsernameNotFoundException("El usuario no existe"));
        ListaCompras lista = ListaCompraMapper.mapearRequestEntidad(listaRequest, usuario);
        ListaCompras savedLista = listaComprasRepository.save(lista);

        return ListaCompraMapper.mapearResponse(savedLista);
    }

    @Override
    public List<ListaCompraProductosResponse> findAllProductosListaUsuario(String username, String listname) {
        Usuario usuario = this.userRepository.findByUsuario(username).orElseThrow(() -> new UsernameNotFoundException("El usuario no existe"));
        ListaCompras lista=this.listaComprasRepository.findByNombreAndUsuario(listname, usuario);
        if (lista==null) {
            return null;
        }
        List<ListaCompraProductosResponse> response = new ArrayList<ListaCompraProductosResponse>();
        for (ListaProducto listaProducto: lista.getListas()) {
            response.add(ListaCompraProductosMapper.mapearResponse(this.productoRepository.getById(listaProducto.getId().getId_producto()), listaProducto));
        }
        return response;
    }

    @Override
    public Boolean eliminarLista(String usuario, ListaCompras listaComprasVar) {
        if (listaComprasVar.getListas()!=null) {
            for (ListaProducto producto : listaComprasVar.getListas()) {
            listaProductoRepository.delete(producto);
            }
        }
        
        listaComprasRepository.delete(listaComprasVar);
        return true;
    }

    
}

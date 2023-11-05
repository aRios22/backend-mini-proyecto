package com.unicauca.backendminiproyecto.service.implementation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.unicauca.backendminiproyecto.domain.Producto;
import com.unicauca.backendminiproyecto.dto.response.ProductoNombreResponse;
import com.unicauca.backendminiproyecto.mapper.ProductoNombreResponseMapper;
import com.unicauca.backendminiproyecto.repository.ProductoRepository;
import com.unicauca.backendminiproyecto.service.interfaz.ProductoService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class ProductoServiceImpl implements ProductoService{

    private ProductoRepository productoRepository;

    @Override
    public List<ProductoNombreResponse> findAll() {
        List<Producto> list = new ArrayList<Producto>();
        List<ProductoNombreResponse> response = new ArrayList<ProductoNombreResponse>();
        list=this.productoRepository.findAll();
        if (list.size()==0) {
            return null;
        }
        for (Producto producto : list) {
            response.add(ProductoNombreResponseMapper.mapearResponse(producto));
        }
        return response;
    }
    
}

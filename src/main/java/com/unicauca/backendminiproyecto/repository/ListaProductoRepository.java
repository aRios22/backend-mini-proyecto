package com.unicauca.backendminiproyecto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.unicauca.backendminiproyecto.domain.ListaProducto;
import com.unicauca.backendminiproyecto.domain.ListaProductoId;

@Repository
public interface ListaProductoRepository extends JpaRepository<ListaProducto, ListaProductoId>{
    
}

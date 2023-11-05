package com.unicauca.backendminiproyecto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.unicauca.backendminiproyecto.domain.Producto;

@Repository
public interface ProductoRepository  extends JpaRepository<Producto, Long>{
    
}

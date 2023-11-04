package com.unicauca.backendminiproyecto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.unicauca.backendminiproyecto.domain.ListaCompras;
import com.unicauca.backendminiproyecto.domain.Usuario;

@Repository
public interface ListaComprasRepository extends JpaRepository<ListaCompras, Long>{

    ListaCompras findByNombreAndUsuario(String nombre, Usuario usuario);

    
}

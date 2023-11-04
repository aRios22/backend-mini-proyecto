package com.unicauca.backendminiproyecto.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.unicauca.backendminiproyecto.domain.Usuario;


@Repository
public interface UserRepository extends JpaRepository<Usuario, Long>{

    Usuario findByUsuarioAndClave(String usuario, String clave);
    Optional<Usuario> findByUsuario(String username);

}

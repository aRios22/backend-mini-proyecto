package com.unicauca.backendminiproyecto.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.unicauca.backendminiproyecto.domain.Usuario;
import com.unicauca.backendminiproyecto.repository.UserRepository;


@Service
public class UserDetailsServiceImpl implements UserDetailsService{


    @Autowired
    private UserRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String usuario) throws UsernameNotFoundException {
        Usuario admin = usuarioRepository.findByUsuario(usuario)
        .orElseThrow(() -> new UsernameNotFoundException("El usuario no existe"));
        

        return new UserDetailsImpl(admin);
    }
    
}
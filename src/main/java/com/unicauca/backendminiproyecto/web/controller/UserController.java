package com.unicauca.backendminiproyecto.web.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unicauca.backendminiproyecto.dto.request.LoginRequest;
import com.unicauca.backendminiproyecto.dto.response.LoginResponse;
import com.unicauca.backendminiproyecto.service.interfaz.UserService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/api/user")
public class UserController {
    
    private UserService userService;

    @PostMapping("/login/")
    public ResponseEntity<?> loginAdministrador(@RequestBody LoginRequest loginRequest) {
        LoginResponse response = userService.logIn(loginRequest);
        
        if(response != null){
            return ResponseEntity.ok(response);
        }
        return  ResponseEntity.status(HttpStatus.NOT_FOUND).body("Su usuario o contraseña son incorrectos.");
    }

}
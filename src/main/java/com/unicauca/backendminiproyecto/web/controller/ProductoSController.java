package com.unicauca.backendminiproyecto.web.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.unicauca.backendminiproyecto.dto.response.ListaCompraResponse;
import com.unicauca.backendminiproyecto.dto.response.ProductoNombreResponse;
import com.unicauca.backendminiproyecto.service.interfaz.ProductoService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/api/producto")
public class ProductoSController {

    private ProductoService productoService;

    @GetMapping("/listar/")
        public ResponseEntity<?> getProductos() {
            List<ProductoNombreResponse> response= productoService.findAll();
            if(response==null){
                return  ResponseEntity.status(HttpStatus.NOT_FOUND).body("No hay productos.");
            }
            return ResponseEntity.ok(response); 
        }
    
}

package com.unicauca.backendminiproyecto.web.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.unicauca.backendminiproyecto.domain.ListaCompras;
import com.unicauca.backendminiproyecto.dto.response.ListaProductoResponse;
import com.unicauca.backendminiproyecto.service.interfaz.ListaCompraService;
import com.unicauca.backendminiproyecto.service.interfaz.ListaProductoService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@CrossOrigin(origins = "http://localhost:4200/", maxAge = 3600)
@RequestMapping("/api/lista-producto")
public class ListaProductoController {

    private ListaCompraService listaCompraService;
    private ListaProductoService listaProductoService;

    @PostMapping("/registrar/")
    public ResponseEntity<?> registrarEmpadronado(@RequestParam("usuario") String usuario, @RequestParam("listacompras") String listaCompras, @RequestParam("producto") String producto) {
        ListaCompras listaComprasVar = listaCompraService.findByNombre(listaCompras, usuario);
        if(listaCompras==null){
            return  ResponseEntity.status(HttpStatus.CONFLICT).body("No existe una lista de compra con se nombre.");
        }
       
        ListaProductoResponse response = listaProductoService.registrarListaProducto(producto, usuario, listaComprasVar);
        if (response == null) {
            return  ResponseEntity.status(HttpStatus.CONFLICT).body("Error durante la creación");
        }
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/eliminar/")
    public ResponseEntity<?> eliminarEmpadronado(@RequestParam("usuario") String usuario, @RequestParam("listacompras") String listaCompras, @RequestParam("producto") String producto) {
        ListaCompras listaComprasVar = listaCompraService.findByNombre(listaCompras, usuario);
        if(listaCompras==null){
            return  ResponseEntity.status(HttpStatus.CONFLICT).body("No existe una lista de compra con se nombre.");
        }
        
        Boolean response = listaProductoService.eliminarListaProducto(producto, usuario, listaComprasVar);
        if (!response) {
            return  ResponseEntity.status(HttpStatus.CONFLICT).body("Error durante la eliminación");
        }
        return ResponseEntity.ok(response);
    }
    
}

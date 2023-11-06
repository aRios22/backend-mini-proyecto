package com.unicauca.backendminiproyecto.web.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.unicauca.backendminiproyecto.domain.ListaCompras;
import com.unicauca.backendminiproyecto.dto.request.ListaCompraRequest;
import com.unicauca.backendminiproyecto.dto.response.ListaCompraProductosResponse;
import com.unicauca.backendminiproyecto.dto.response.ListaCompraResponse;
import com.unicauca.backendminiproyecto.service.interfaz.ListaCompraService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@CrossOrigin(origins = "http://localhost:4200/", maxAge = 3600)
@RequestMapping("/api/lista-compras")
public class ListaComprasController {

    private ListaCompraService listaCompraService;

    @GetMapping("/listar/")
    public ResponseEntity<?> getListasUsuario(@RequestParam("usuario") String usuario) {
        List<ListaCompraResponse> response= listaCompraService.findAllUsuario(usuario);
        if(response==null){
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).body("No hay listas.");
        }
        return ResponseEntity.ok(response); 
    }

    @GetMapping("/listar-productos/")
    public ResponseEntity<?> getProductosListasUsuario(@RequestParam("usuario") String usuario, @RequestParam("listname") String listname) {
        List<ListaCompraProductosResponse> response= listaCompraService.findAllProductosListaUsuario(usuario, listname);
        if(response==null){
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).body("No hay Productos Registrados.");
        }
        return ResponseEntity.ok(response); 
    }

    @PostMapping("/registrar/")
    public ResponseEntity<?> registrarEmpadronado(@RequestParam("usuario") String usuario, @RequestBody ListaCompraRequest listaRequest) {
        ListaCompras listaCompras = listaCompraService.findByNombre(listaRequest.getNombre(), usuario);
        if(listaCompras!=null){
            return  ResponseEntity.status(HttpStatus.CONFLICT).body("Ya existe una lista con ese nombre.");
        }
        
        ListaCompraResponse response = listaCompraService.registrarLista(listaRequest, usuario);
        if (response == null) {
            return  ResponseEntity.status(HttpStatus.CONFLICT).body("Error durante la creación");
        }
        return ResponseEntity.ok(response);
    }

     @DeleteMapping("/eliminar/")
    public ResponseEntity<?> eliminarLista(@RequestParam("usuario") String usuario, @RequestParam("listacompras") String listaCompras) {
        ListaCompras listaComprasVar = listaCompraService.findByNombre(listaCompras, usuario);
        if(listaComprasVar==null){
            return  ResponseEntity.status(HttpStatus.CONFLICT).body("No existe una lista de compra con se nombre.");
        }
        Boolean response = listaCompraService.eliminarLista(usuario, listaComprasVar);
        if (!response) {
            return  ResponseEntity.status(HttpStatus.CONFLICT).body("Error durante la eliminación");
        }
        return ResponseEntity.ok(response);
    }
    
}

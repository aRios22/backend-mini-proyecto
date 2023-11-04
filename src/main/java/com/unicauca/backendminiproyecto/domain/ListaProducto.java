package com.unicauca.backendminiproyecto.domain;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "lista_producto")
public class ListaProducto {

    @EmbeddedId
    private ListaProductoId id;

    @ManyToOne
    @MapsId("id_lista")
    @JoinColumn(name = "id_lista")
    ListaCompras administrador;

    @ManyToOne
    @MapsId("id_producto")
    @JoinColumn(name = "id_producto")
    Producto empadronado;

    @Column(name = "estado")
    private String estado; 
    
}

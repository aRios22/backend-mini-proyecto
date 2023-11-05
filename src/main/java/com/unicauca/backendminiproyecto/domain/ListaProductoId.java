package com.unicauca.backendminiproyecto.domain;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class ListaProductoId implements Serializable{
     
    @Column(name = "id_lista")
    long id_lista;

    @Column(name = "id_producto")
    long id_producto;


    @Override
    public int hashCode() {
        return 1;
    }
        
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (this.getClass() != o.getClass()) return false;
        ListaProductoId user = (ListaProductoId) o;
        return id_lista == user.id_lista 
          && (id_producto==user.id_producto);
    }
}

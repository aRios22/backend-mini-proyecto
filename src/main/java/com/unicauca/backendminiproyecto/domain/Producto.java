package com.unicauca.backendminiproyecto.domain;

import java.time.LocalDateTime;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "producto")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

	@Column(name = "nombre")
    private String nombre;

    @Column(name = "precio")
    private int precio;

    @Column(name = "fecha")
    private LocalDateTime fechaHoraAprobacion;

    @ManyToOne
    @JoinColumn(name="id_proveedor", nullable=false)
    private Proveedor proveedor;

    @OneToMany(mappedBy="producto")
    private Set<ListaProducto> producto;
    
}

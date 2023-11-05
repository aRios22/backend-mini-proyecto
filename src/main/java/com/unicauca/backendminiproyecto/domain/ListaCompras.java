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
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "lista_compras")
public class ListaCompras {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

	@Column(name = "nombre")
    private String nombre;

    @Column(name = "fecha")
    private LocalDateTime fecha; 
    
    @ManyToOne
    @JoinColumn(name="id_usuario", nullable=false)
    private Usuario usuario;

    @OneToMany(mappedBy="listas")
    private Set<ListaProducto> listas;
    
}

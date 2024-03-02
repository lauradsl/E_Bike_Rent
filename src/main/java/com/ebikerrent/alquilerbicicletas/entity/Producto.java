package com.ebikerrent.alquilerbicicletas.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;


@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "PRODUCTOS", uniqueConstraints = @UniqueConstraint(columnNames = {"NOMBRE"}))
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NOMBRE")
    private String nombre;

    @Column(name = "DESCRIPCION")
    private String descripcion;

    //DEBE QUEDAR ASI PARA QUE PERSISTA INFO EN BD
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "producto_id")
    private Set<Imagen> imagenes = new HashSet<>();

    @Column(name = "categoria_id")
    private Long categoriaId;


    private String categoriaP;

    /*@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "categoria_id", referencedColumnName = "id")
    private Categoria categoria;*/


}

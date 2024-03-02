package com.ebikerrent.alquilerbicicletas.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;


@Entity
@Setter
@Getter
@ToString
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

    /*@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "categoria_id", referencedColumnName = "id")
    private Categoria categoria;*/

    @Override
    public String toString() {
        return "Producto{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", imagenes=" + imagenes +
                ", categoria=" + categoriaId +
                '}';
    }
}

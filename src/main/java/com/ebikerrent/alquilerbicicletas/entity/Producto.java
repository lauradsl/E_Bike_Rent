package com.ebikerrent.alquilerbicicletas.entity;

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

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "producto_id")
    private Set<Imagen> imagenes = new HashSet<>();

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "categoria_id", referencedColumnName = "id")
    private Categoria categoria;


    //cascade = CascadeType.ALL Agregamos la cascada? significaría que las operaciones de persistencia (crear, actualizar, eliminar, buscar) realizadas en un objeto Producto también se deben propagar a las imágenes asociadas

    //HashSet es una implementación de la interfaz Set en Java que representa una colección de elementos únicos sin un orden específico
    //HashSet contiene elementos únicos y no permite duplicados. La operación de agregar elementos por segunda vez se ignora. No hay un orden de inserción.



    @Override
    public String toString() {
        return "Producto{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", imagenes=" + imagenes +
                ", categoria=" + categoria +
                '}';
    }
}

package com.ebikerrent.alquilerbicicletas.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Table(name = "IMAGENES")
public class Imagen {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "TITULO")
    private String titulo;
    @Column(name = "URLIMG")
    private String urlImg;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.PERSIST)
    @JoinColumn(name = "producto_id", referencedColumnName = "id")
    private Producto producto;



    //Las anotaciones fetch y cascade en el contexto de JPA (Java Persistence API) son utilizadas para definir el comportamiento de carga (fetch) y las operaciones de cascada en las relaciones entre entidades.
    //FetchType.LAZY:Lazy (perezoso) indica que la carga de la relación se realiza de manera diferida, es decir, los datos relacionados no se cargan de inmediato junto con la entidad principal, sino que se cargan solo cuando se accede a ellos.
    //Esto es útil cuando se trabaja con grandes conjuntos de datos o cuando no siempre se necesita la información relacionada.
    //Por ejemplo, si tienes una entidad Usuario con una relación @OneToMany a una colección de Pedidos, marcar la relación como FetchType.LAZY significa que los pedidos no se cargarán automáticamente cuando obtienes un usuario, sino solo cuando accedes a la colección de pedidos.
    //CascadeType.PERSIST indica que las operaciones de persistencia (guardar en la base de datos) deben propagarse automáticamente a las entidades relacionadas.Esto significa que cuando guardas una nueva imagen, también se persistirá automáticamente el producto asociado.
    //Por ejemplo, si tienes una entidad Usuario con una relación @OneToMany a una colección de Pedidos y marcas la relación como CascadeType.PERSIST, cuando guardas un nuevo usuario que tiene nuevos pedidos, los pedidos también se guardarán automáticamente en la base de datos.

    @Override
    public String toString() {
        return " \n Imagen{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", urlImg='" + urlImg + '\'' +

                '}' + '\n';
    }
}


package com.ebikerrent.alquilerbicicletas.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Table(name = "IMAGENES")
public class Imagen {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "TITULO")
    private String titulo;
    @Column(name = "URLIMG")
    private String urlImg;

    /*@Column(name ="producto_id")
    private Long productoId;*/

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "producto_id", referencedColumnName = "id")
    @JsonIgnore
    private Producto producto;


}
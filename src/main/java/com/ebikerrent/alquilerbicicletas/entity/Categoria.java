package com.ebikerrent.alquilerbicicletas.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "CATEGORIAS")
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "TITULO")
    private String titulo;

    @OneToMany(fetch = FetchType.LAZY,cascade =CascadeType.ALL)
    @JsonIgnore
    private Set<Producto> productos=new HashSet<>();


//CascadeType.ALL: Indica que todas las operaciones de persistencia deben propagarse a las entidades asociadas. Esto incluye INSERT, UPDATE y DELETE.
//CascadeType.PERSIST: Indica que solo las operaciones de persistencia de INSERT deben propagarse a las entidades asociadas.
//CascadeType.MERGE: Indica que solo las operaciones de persistencia de UPDATE deben propagarse a las entidades asociadas.
//CascadeType.REMOVE: Indica que solo las operaciones de persistencia de DELETE deben propagarse a las entidades asociadas.
//CascadeType.REFRESH: Indica que las operaciones de actualización de la entidad principal deben propagarse a las entidades asociadas.

    @Override
    public String toString() {
        return " \n Categoria{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +

                '}' + '\n';
    }
}


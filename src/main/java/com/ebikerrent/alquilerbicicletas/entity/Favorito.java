package com.ebikerrent.alquilerbicicletas.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Table(name = "favoritos")
public class Favorito {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "favorito_id")
    private Long id;

    @Column(name = "favorito")
    private Boolean favorito;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "producto_id")
    private Producto producto;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @Override
    public String toString() {
        return "Favorito{" +
                "id=" + id +
                ", favorito=" + favorito +
                ", producto=" + producto +
                ", usuario=" + usuario +
                '}';
    }
}

package com.ebikerrent.alquilerbicicletas.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Table(name = "usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "usuario_id")
    private Long id;

    private String nombre;

    private String apellido;

    private String email;

    private String password;

    @ManyToOne(fetch = FetchType.LAZY)
    private Tipo_Usuario tipo_usuario;

}

package com.ebikerrent.alquilerbicicletas.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

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
    private Long id;

    @Column(name="NOMBRE")
    @Size(min = 1, max = 250)
    private String nombre;

    @Column(name="APELLIDO")
    @Size(min = 1, max = 250)
    private String apellido;

    @Column(name="EMAIL",unique = true)
    @Size(min = 1, max = 250)
    private String mail;

    @Column(name="TELEFONO")
    private String telefono;

    @Column(name="password")
    @Size(min = 1, max = 250)
    private String password;

    private boolean esAdmin;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Reserva> reservas = new ArrayList<>();
}

package com.ebikerrent.alquilerbicicletas.dto.entrada.usuario;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UsuarioEntradaDto {
    private String nombre;
    private String apellido;
    private String email;
    private String password;

}

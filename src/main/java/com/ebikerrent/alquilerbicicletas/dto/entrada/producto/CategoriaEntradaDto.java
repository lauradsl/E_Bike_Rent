package com.ebikerrent.alquilerbicicletas.dto.entrada.producto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class CategoriaEntradaDto {
    @NotNull(message = "Este campo Categoria no debe ser nulo")
    @NotBlank(message = "Este campo no debe estar vacío")
    private String titulo;



}

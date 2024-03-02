package com.ebikerrent.alquilerbicicletas.dto.entrada.modificacion;

import com.ebikerrent.alquilerbicicletas.dto.entrada.producto.CategoriaEntradaDto;
import com.ebikerrent.alquilerbicicletas.dto.entrada.producto.ImagenEntradaDto;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductoModificacionEntradaDto {
    @NotNull
    private Long id;

    @NotNull
    @NotBlank
    private String nombre;
    @NotNull
    @NotBlank
    private String descripcion;

    @Valid
    private ImagenEntradaDto imagenEntradaDto;

    @Valid
    private CategoriaEntradaDto categoriaEntradaDto;
}

//Los DTOs de modificación (ProductoModificacionEntradaDto) se utilizan específicamente cuando se desea modificar un objeto existente.
//Pueden contener solo los campos que se permiten modificar y son diferentes de los DTOs de entrada y salida.

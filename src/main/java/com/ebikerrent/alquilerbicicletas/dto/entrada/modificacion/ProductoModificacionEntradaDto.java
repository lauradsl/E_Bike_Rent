package com.ebikerrent.alquilerbicicletas.dto.entrada.modificacion;

import com.ebikerrent.alquilerbicicletas.dto.entrada.producto.CategoriaEntradaDto;
import com.ebikerrent.alquilerbicicletas.dto.entrada.producto.ImagenEntradaDto;
import com.ebikerrent.alquilerbicicletas.entity.Imagen;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Transient;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductoModificacionEntradaDto {
    @NotNull
    private Long id;
    @NotNull(message = "Debe ingresar un nombre")
    @NotBlank(message = "Debe especificar un nombre")
    private String nombre;
    @NotNull(message = "Debe ingresar una descripcion")
    @NotBlank(message = "Debe especificar una descripcion")
    private String descripcion;
    @NotNull(message = "Debe ingresar un titulo de Categoria")
    @NotBlank(message = "Debe especificar un titulo de Categoria")
    @JsonProperty("categoria")
    private String tituloCategoria;

    /*@NotNull
    @Valid
    private Set<Imagen> imagenes = new HashSet<>();
    @Valid
    private CategoriaEntradaDto categoriaEntradaDto;*/
}

//Los DTOs de modificación (ProductoModificacionEntradaDto) se utilizan específicamente cuando se desea modificar un objeto existente.
//Pueden contener solo los campos que se permiten modificar y son diferentes de los DTOs de entrada y salida.

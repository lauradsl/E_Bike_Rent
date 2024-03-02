package com.ebikerrent.alquilerbicicletas.dto.entrada.producto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
//es una anotación de Jackson, que es una biblioteca de Java para procesar JSON. Esta anotación se utiliza en la definición de clases de Java que se mapearán desde o hacia JSON, y su propósito es ignorar propiedades desconocidas durante la deserialización.
public class ProductoEntradaDto {
    @NotNull (message = "El nombre del producto no puede ser nula")
    @NotBlank(message = "El nombre debe especificarse")
    @Size(min = 1, max = 250)
    private String nombre;

    @NotNull(message = "La descripción del producto no puede ser nula")
    @NotBlank(message = "La descripción debe especificarse")
    @Size(min = 1, max = 250)
    private String descripcion;

    @Valid //Valida en su propia clase
    @JsonProperty("imagenes")
    private Set<ImagenEntradaDto> imagenEntradaDtos = new HashSet<>();

    @NotNull(message = "El ID de la categoría no puede ser nulo")
    @JsonProperty("categoria")
    private String categoriaString;
    //private Long categoriaId;

    /*@Valid//Valida en su propia clase
    @JsonProperty("categoria")
    private CategoriaEntradaDto categoriaEntradaDto;*/


}
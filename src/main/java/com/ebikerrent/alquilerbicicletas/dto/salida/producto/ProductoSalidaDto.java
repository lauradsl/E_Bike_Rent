package com.ebikerrent.alquilerbicicletas.dto.salida.producto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class ProductoSalidaDto {
    private Long id;
    private String nombre;
    private String descripcion;

    @JsonProperty("categoria")
    private CategoriaSalidaDto categoriaSalidaDto;

    @JsonProperty("imagenes")
    private Set<ImagenSalidaDto> imagenes = new HashSet<>();



}

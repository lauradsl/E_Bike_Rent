package com.ebikerrent.alquilerbicicletas.dto.salida.producto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class ProductoSalidaDto {
    private Long id;
    private String nombre;
    private String descripcion;

    @JsonProperty("categoria")
    private CategoriaSalidaDto categoriaSalidaDto;

    @JsonProperty("imagenes")
    private Set<ImagenSalidaDto> imagenSalidaDto= new HashSet<>();



}

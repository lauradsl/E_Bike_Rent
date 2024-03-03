package com.ebikerrent.alquilerbicicletas.dto.salida.producto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class CategoriaSalidaDto {
    private int id;
    private String titulo;

    /*@JsonProperty("productos")
    private ProductoSalidaDto productoSalidaDto;*/
}
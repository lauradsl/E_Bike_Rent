package com.ebikerrent.alquilerbicicletas.dto.salida.producto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class ImagenSalidaDto {
    private Long id;
    private String titulo;
    private String urlImg;
    /*@JsonProperty("productos")
    private ProductoSalidaDto productoSalidaDto;*/

}

package com.ebikerrent.alquilerbicicletas.dto.salida.producto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class ImagenSalidaDto {
    private Long id;
    private String titulo;
    private String urlImg;
    /*@JsonProperty("productos")
    private ProductoSalidaDto productoSalidaDto;*/

}

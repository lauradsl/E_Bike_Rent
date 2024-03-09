package com.ebikerrent.alquilerbicicletas.dto.salida;

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

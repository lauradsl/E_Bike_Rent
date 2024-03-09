package com.ebikerrent.alquilerbicicletas.dto.salida;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class CategoriaSalidaDto {
    private int id;
    private String titulo;
    private String descripcion;
    private String imagen;

    /*@JsonProperty("productos")
    private ProductoSalidaDto productoSalidaDto;*/
}
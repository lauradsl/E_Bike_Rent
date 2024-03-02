package com.ebikerrent.alquilerbicicletas.dto.salida.producto;

import ch.qos.logback.classic.Logger;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.JoinColumn;
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
    //@JsonProperty("productos_id")
    //private Long productoId;


}

package com.ebikerrent.alquilerbicicletas.dto.entrada.producto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ImagenEntradaDto {
    @NotNull(message = "Este campo no debe ser nulo")
    @NotBlank(message = "Este campo no debe estar vacío")
    private String titulo;
    @NotNull(message = "Este campo no debe ser nulo")
    @NotBlank(message = "Este campo no debe estar vacío")
    private String urlImg;

    //private ProductoEntradaDto productoEntradaDto;
    public ImagenEntradaDto(String titulo, String urlImg) {
        this.titulo = titulo;
        this.urlImg = urlImg;
    }

    public ImagenEntradaDto() {
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getUrlImg() {
        return urlImg;
    }

    public void setUrlImg(String urlImg) {
        this.urlImg = urlImg;
    }
}

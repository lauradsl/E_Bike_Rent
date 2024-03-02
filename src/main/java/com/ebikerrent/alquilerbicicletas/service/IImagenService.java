package com.ebikerrent.alquilerbicicletas.service;

import com.ebikerrent.alquilerbicicletas.dto.entrada.modificacion.ImagenModificacionEntradaDto;
import com.ebikerrent.alquilerbicicletas.dto.entrada.producto.ImagenEntradaDto;
import com.ebikerrent.alquilerbicicletas.dto.salida.producto.ImagenSalidaDto;

import java.util.List;

public interface IImagenService {
    List<ImagenSalidaDto> listarImagenes();
    ImagenSalidaDto registrarImagen(ImagenEntradaDto imagenEntradaDto);
    ImagenSalidaDto buscarImagenPorId(Long id);
    void eliminarImagen(Long id);
    ImagenSalidaDto modificarImagen(ImagenModificacionEntradaDto imagenModificacionEntradaDto);
}

package com.ebikerrent.alquilerbicicletas.service;

import com.ebikerrent.alquilerbicicletas.dto.entrada.modificacion.ImagenModificacionEntradaDto;
import com.ebikerrent.alquilerbicicletas.dto.entrada.producto.ImagenEntradaDto;
import com.ebikerrent.alquilerbicicletas.dto.salida.ImagenSalidaDto;
import com.ebikerrent.alquilerbicicletas.exceptions.ResourceNotFoundException;

import java.util.List;

public interface IImagenService {
    List<ImagenSalidaDto> listarImagenes();
    ImagenSalidaDto registrarImagen(ImagenEntradaDto imagenEntradaDto) throws ResourceNotFoundException;
    ImagenSalidaDto buscarImagenPorId(Long id) throws ResourceNotFoundException;
    void eliminarImagen(Long id) throws ResourceNotFoundException;
    ImagenSalidaDto modificarImagen(ImagenModificacionEntradaDto imagenModificacionEntradaDto) throws ResourceNotFoundException;
}

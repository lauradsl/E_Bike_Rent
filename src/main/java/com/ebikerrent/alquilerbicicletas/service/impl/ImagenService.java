package com.ebikerrent.alquilerbicicletas.service.impl;

import com.ebikerrent.alquilerbicicletas.dto.entrada.modificacion.ImagenModificacionEntradaDto;
import com.ebikerrent.alquilerbicicletas.dto.entrada.producto.ImagenEntradaDto;
import com.ebikerrent.alquilerbicicletas.dto.salida.producto.ImagenSalidaDto;
import com.ebikerrent.alquilerbicicletas.dto.salida.producto.ProductoSalidaDto;
import com.ebikerrent.alquilerbicicletas.entity.Imagen;
import com.ebikerrent.alquilerbicicletas.entity.Producto;
import com.ebikerrent.alquilerbicicletas.repository.ImagenRepository;
import com.ebikerrent.alquilerbicicletas.service.IImagenService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ImagenService implements IImagenService {
    private final Logger LOGGER = LoggerFactory.getLogger(ImagenService.class);
    private final ImagenRepository imagenRepository;
    private final ModelMapper modelMapper;

    public ImagenService(ImagenRepository imagenRepository, ModelMapper modelMapper) {
        this.imagenRepository = imagenRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<ImagenSalidaDto> listarImagenes() {
        List<Imagen> imagenes = imagenRepository.findAll();
        List<ImagenSalidaDto> imagenSalidaDtoList= new ArrayList<>();

        for (Imagen img: imagenes){

            ImagenSalidaDto imagenSalidaDto = entidadAdtoSalida(img);
            imagenSalidaDtoList.add(imagenSalidaDto);
        }
        LOGGER.info("Listado de todos las imagenes : " + imagenes);

        return imagenSalidaDtoList;
    }

    @Override
    public ImagenSalidaDto registrarImagen(ImagenEntradaDto imagenEntradaDto) {
        Imagen imagenRecibida = dtoEntradaAentidad(imagenEntradaDto);

        Imagen imagenRegistrada = imagenRepository.save((imagenRecibida));
        ImagenSalidaDto imagenResultado = entidadAdtoSalida(imagenRegistrada);
        LOGGER.info("IMAGEN REGISTRADA: " + imagenRegistrada);
        return imagenResultado;
    }

    @Override
    public ImagenSalidaDto buscarImagenPorId(Long id) {
        Imagen imagenBuscado = imagenRepository.findById(id).orElse(null);

        ImagenSalidaDto imagenEncontrado = null;
        if (imagenBuscado != null){
            imagenEncontrado = entidadAdtoSalida(imagenBuscado);
            LOGGER.info("Imagen encontrado : " + imagenBuscado);
        }else
            LOGGER.error("El id de la imagen no se encuentra en la base de datos");

        return imagenEncontrado;
    }

    @Override
    public void eliminarImagen(Long id) {
        if (buscarImagenPorId(id) != null){
            LOGGER.warn("Se eliminó la imagen con el id : " + dtoSalidaAentidad(buscarImagenPorId(id)));
            imagenRepository.deleteById(id);
        }else
            LOGGER.error("No se encontró la imagen con el id : " + id);
    }

    @Override
    public ImagenSalidaDto modificarImagen(ImagenModificacionEntradaDto imagenModificacionEntradaDto) {
        Imagen imagenAmodificar = dtoModificacioAentidad(imagenModificacionEntradaDto);
        Imagen imagenPorID = imagenRepository.findById(imagenAmodificar.getId()).orElse(null);

        ImagenSalidaDto imagenSalidaDtoModificado = null;
        if (imagenPorID !=null){
            Imagen imagenModificado = imagenRepository.save(imagenAmodificar);
            imagenSalidaDtoModificado = entidadAdtoSalida((imagenModificado));
            LOGGER.info("Imagen Modificado : " + imagenModificado);
        }else
            LOGGER.error("La imagen no se encontró");

        return imagenSalidaDtoModificado;
    }



    public Imagen dtoEntradaAentidad(ImagenEntradaDto imagenEntradaDto){
        return modelMapper.map(imagenEntradaDto, Imagen.class);
    }

    public ImagenSalidaDto entidadAdtoSalida(Imagen imagen){
        return modelMapper.map(imagen, ImagenSalidaDto.class);
    }
    public Imagen dtoSalidaAentidad (ImagenSalidaDto imagenSalidaDto){
        return modelMapper.map(imagenSalidaDto, Imagen.class);
    }

    public Imagen dtoModificacioAentidad (ImagenModificacionEntradaDto imagenModificacionEntradaDto){
        return modelMapper.map(imagenModificacionEntradaDto,Imagen.class);
    }
}

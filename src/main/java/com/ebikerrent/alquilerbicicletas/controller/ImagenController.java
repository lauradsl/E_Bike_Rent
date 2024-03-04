package com.ebikerrent.alquilerbicicletas.controller;
import com.ebikerrent.alquilerbicicletas.dto.entrada.modificacion.ImagenModificacionEntradaDto;
import com.ebikerrent.alquilerbicicletas.dto.entrada.producto.ImagenEntradaDto;
import com.ebikerrent.alquilerbicicletas.dto.salida.producto.ImagenSalidaDto;
import com.ebikerrent.alquilerbicicletas.exceptions.ResourceNotFoundException;
import com.ebikerrent.alquilerbicicletas.service.IImagenService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/imagen")
public class ImagenController {
    private final IImagenService iImagenService;

    public ImagenController(IImagenService iImagenService) {
        this.iImagenService = iImagenService;
    }


    @PostMapping("/registrar")
    public ResponseEntity<ImagenSalidaDto> registrarImagen(@Valid @RequestBody ImagenEntradaDto imagenEntradaDto)throws ResourceNotFoundException{
        return new ResponseEntity<>(iImagenService.registrarImagen(imagenEntradaDto) , HttpStatus.CREATED);
    }

    @GetMapping("/listar")
    public ResponseEntity<List<ImagenSalidaDto>> listarImagenes(){
        return new ResponseEntity<>(iImagenService.listarImagenes(), HttpStatus.OK);
    }

    @PutMapping("/modificar")
    public ResponseEntity<ImagenSalidaDto> modificarImagen(@Valid @RequestBody ImagenModificacionEntradaDto imagenModificacionEntradaDto) throws ResourceNotFoundException {
        return new ResponseEntity<>(iImagenService.modificarImagen(imagenModificacionEntradaDto), HttpStatus.OK);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?>eliminarProducto(@PathVariable Long id ) throws ResourceNotFoundException {
        iImagenService.eliminarImagen(id);
        return new ResponseEntity<>("Imagen eliminado correctamente", HttpStatus.NO_CONTENT);
    }




}

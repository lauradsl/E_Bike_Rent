package com.ebikerrent.alquilerbicicletas.controller;
import com.ebikerrent.alquilerbicicletas.dto.entrada.producto.ImagenEntradaDto;
import com.ebikerrent.alquilerbicicletas.dto.salida.producto.ImagenSalidaDto;
import com.ebikerrent.alquilerbicicletas.service.IImagenService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/imagenes")
public class ImagenController {
    private final IImagenService iImagenService;

    public ImagenController(IImagenService iImagenService) {
        this.iImagenService = iImagenService;
    }


    @PostMapping("registrar")
    public ResponseEntity<ImagenSalidaDto> registrarImagen(@Valid @RequestBody ImagenEntradaDto imagenEntradaDto){
        return new ResponseEntity<>(iImagenService.registrarImagen(imagenEntradaDto) , HttpStatus.CREATED);
    }

    @GetMapping("listar")
    public ResponseEntity<List<ImagenSalidaDto>> listarImagenes(){
        return new ResponseEntity<>(iImagenService.listarImagenes(), HttpStatus.OK);
    }
}

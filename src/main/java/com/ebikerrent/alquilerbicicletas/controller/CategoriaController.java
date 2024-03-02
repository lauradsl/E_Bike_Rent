package com.ebikerrent.alquilerbicicletas.controller;

import com.ebikerrent.alquilerbicicletas.dto.entrada.producto.CategoriaEntradaDto;
import com.ebikerrent.alquilerbicicletas.dto.salida.producto.CategoriaSalidaDto;
import com.ebikerrent.alquilerbicicletas.service.ICategoriaService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/categorias")
public class CategoriaController {

    private final ICategoriaService iCategoriaService;

    public CategoriaController(ICategoriaService iCategoriaService) {
        this.iCategoriaService = iCategoriaService;
    }

    @PostMapping("registrar")
    public ResponseEntity<CategoriaSalidaDto> registrarCategoria(@Valid @RequestBody CategoriaEntradaDto categoriaEntradaDto){
        return new ResponseEntity<>(iCategoriaService.registrarCategoria(categoriaEntradaDto) , HttpStatus.CREATED);
    }

    @GetMapping("listar")
    public ResponseEntity<List<CategoriaSalidaDto>> listarCategorias(){
        return new ResponseEntity<>(iCategoriaService.listarCategorias(), HttpStatus.OK);
    }
}

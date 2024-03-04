package com.ebikerrent.alquilerbicicletas.controller;

import com.ebikerrent.alquilerbicicletas.dto.entrada.modificacion.CategoriaModificacionEntradaDto;
import com.ebikerrent.alquilerbicicletas.dto.entrada.producto.CategoriaEntradaDto;
import com.ebikerrent.alquilerbicicletas.dto.salida.producto.CategoriaSalidaDto;
import com.ebikerrent.alquilerbicicletas.exceptions.BadRequestException;
import com.ebikerrent.alquilerbicicletas.exceptions.ResourceNotFoundException;
import com.ebikerrent.alquilerbicicletas.service.ICategoriaService;
import com.ebikerrent.alquilerbicicletas.service.impl.ProductoService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/categorias")
public class CategoriaController {

    private final ICategoriaService iCategoriaService;
    private final Logger LOGGER = LoggerFactory.getLogger(ProductoService.class);

    public CategoriaController(ICategoriaService iCategoriaService) {
        this.iCategoriaService = iCategoriaService;
    }

    /*@PostMapping("/registrar")
    public ResponseEntity<CategoriaSalidaDto> registrarCategoria(@Valid @RequestBody CategoriaEntradaDto categoriaEntradaDto) throws BadRequestException
    {
        return new ResponseEntity<>(iCategoriaService.registrarCategoria(categoriaEntradaDto) , HttpStatus.CREATED);
    }*/

    @PostMapping("/registrar")
    public ResponseEntity<CategoriaSalidaDto> registrarCategoria(@Valid @RequestBody CategoriaEntradaDto categoriaEntradaDto) throws BadRequestException {
        try {
            CategoriaSalidaDto categoriaRegistrada = iCategoriaService.registrarCategoria(categoriaEntradaDto);
            return new ResponseEntity<>(categoriaRegistrada, HttpStatus.CREATED);
        } catch (BadRequestException e) {
            LOGGER.error("Se produjo una excepción BadRequestException: " + e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }


    @GetMapping("/listar")
    public ResponseEntity<List<CategoriaSalidaDto>> listarCategorias(){
        return new ResponseEntity<>(iCategoriaService.listarCategorias(), HttpStatus.OK);
    }

    @PutMapping("/modificar")
    public ResponseEntity<CategoriaSalidaDto>modificarCategoria(@Valid @RequestBody CategoriaModificacionEntradaDto categoriaModificacion)throws ResourceNotFoundException {
        return new ResponseEntity<>(iCategoriaService.modificarCategoria(categoriaModificacion),HttpStatus.OK);
    };

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?>eliminarCategoria(@PathVariable Long id) throws ResourceNotFoundException {
        iCategoriaService.eliminarCategoria(id);
        return new ResponseEntity<>("Categoria eliminada correctamente", HttpStatus.NO_CONTENT);
    }

    }

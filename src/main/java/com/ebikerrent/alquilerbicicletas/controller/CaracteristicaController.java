package com.ebikerrent.alquilerbicicletas.controller;

import com.ebikerrent.alquilerbicicletas.dto.entrada.caracteristica.CaracteristicaEntradaDto;
import com.ebikerrent.alquilerbicicletas.dto.salida.caracteristica.CaracteristicaSalidaDto;
import com.ebikerrent.alquilerbicicletas.exceptions.ResourceNotFoundException;
import com.ebikerrent.alquilerbicicletas.service.ICaracteristicaService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/caracteristicas")
@AllArgsConstructor
public class CaracteristicaController {

    private final ICaracteristicaService iCaracteristicaService;

    @PostMapping("/registrar")
    public ResponseEntity<CaracteristicaSalidaDto> registrarCaracteristica(@Valid @RequestBody CaracteristicaEntradaDto caracteristicaEntradaDto) throws ResourceNotFoundException {
        return new ResponseEntity<>(iCaracteristicaService.registrarCaracteristica(caracteristicaEntradaDto) , HttpStatus.CREATED);
    }

    @GetMapping("listar")
    public ResponseEntity<List<CaracteristicaSalidaDto>> listarCaracteristicas(){
        return new ResponseEntity<>(iCaracteristicaService.listarCaracteristicas(), HttpStatus.OK);
    }
}

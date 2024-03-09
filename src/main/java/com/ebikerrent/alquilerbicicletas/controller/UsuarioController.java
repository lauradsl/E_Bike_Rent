package com.ebikerrent.alquilerbicicletas.controller;

import com.ebikerrent.alquilerbicicletas.dto.entrada.usuario.UsuarioEntradaDto;
import com.ebikerrent.alquilerbicicletas.dto.salida.UsuarioSalidaDto;
import com.ebikerrent.alquilerbicicletas.exceptions.ResourceNotFoundException;
import com.ebikerrent.alquilerbicicletas.service.IUsuarioService;
import jakarta.validation.Valid;
import org.apache.coyote.BadRequestException;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin
public class UsuarioController {
    private final IUsuarioService iUsuarioService;

    public UsuarioController(IUsuarioService iUsuarioService) {
        this.iUsuarioService = iUsuarioService;
    }

    @PostMapping("/registrar")
    public ResponseEntity<UsuarioSalidaDto> registrar(@Valid @RequestBody UsuarioEntradaDto usuarioEntradaDto) throws BadRequestException {
        return new ResponseEntity<>(iUsuarioService.registrarUsuario(usuarioEntradaDto), HttpStatus.CREATED);
    }

    @GetMapping("/listar")
    public ResponseEntity<List<UsuarioSalidaDto>> listar() throws ResourceNotFoundException {
        return new ResponseEntity<>(iUsuarioService.listar(),HttpStatus.OK);
    }
    @GetMapping("/buscarPorId/{id}")
    public ResponseEntity<UsuarioSalidaDto> buscarPorId(@PathVariable Long id) throws ResourceNotFoundException {
        return new ResponseEntity<>(iUsuarioService.buscarUsuarioPorId(id), HttpStatus.OK);
    }
}

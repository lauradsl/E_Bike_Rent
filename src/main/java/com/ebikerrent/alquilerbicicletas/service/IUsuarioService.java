package com.ebikerrent.alquilerbicicletas.service;

import com.ebikerrent.alquilerbicicletas.dto.entrada.modificacion.ProductoModificacionEntradaDto;
import com.ebikerrent.alquilerbicicletas.dto.entrada.modificacion.UsuarioModificacionEntrada;
import com.ebikerrent.alquilerbicicletas.dto.entrada.usuario.UsuarioEntradaDto;
import com.ebikerrent.alquilerbicicletas.dto.salida.ProductoSalidaDto;
import com.ebikerrent.alquilerbicicletas.dto.salida.UsuarioSalidaDto;
import com.ebikerrent.alquilerbicicletas.exceptions.DuplicateEntryException;
import com.ebikerrent.alquilerbicicletas.exceptions.ResourceNotFoundException;
import org.apache.coyote.BadRequestException;

import java.util.List;

public interface IUsuarioService {
    List<UsuarioSalidaDto> listar();
    UsuarioSalidaDto registrarUsuario(UsuarioEntradaDto usuario) throws DuplicateEntryException;
    UsuarioSalidaDto buscarUsuarioPorId(Long id)throws ResourceNotFoundException;
    UsuarioSalidaDto modificarUsuario (UsuarioModificacionEntrada usuarioModificacionEntrada) throws ResourceNotFoundException;

}

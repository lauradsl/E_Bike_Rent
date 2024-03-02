package com.ebikerrent.alquilerbicicletas.service;

import com.ebikerrent.alquilerbicicletas.dto.entrada.modificacion.CategoriaModificacionEntradaDto;
import com.ebikerrent.alquilerbicicletas.dto.entrada.modificacion.ProductoModificacionEntradaDto;
import com.ebikerrent.alquilerbicicletas.dto.entrada.producto.CategoriaEntradaDto;
import com.ebikerrent.alquilerbicicletas.dto.entrada.producto.ProductoEntradaDto;
import com.ebikerrent.alquilerbicicletas.dto.salida.producto.CategoriaSalidaDto;
import com.ebikerrent.alquilerbicicletas.dto.salida.producto.ProductoSalidaDto;

import java.util.List;

public interface ICategoriaService {
    List<CategoriaSalidaDto> listarCategorias();
    CategoriaSalidaDto registrarCategoria(CategoriaEntradaDto categoriaEntradaDto);

    CategoriaSalidaDto buscarCategoriaPorId(Long id);

    void eliminarCategoria(Long id);

    CategoriaSalidaDto modificarCategoria (CategoriaModificacionEntradaDto categoriaModificacionEntradaDto);

}

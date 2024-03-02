package com.ebikerrent.alquilerbicicletas.service.impl;

import com.ebikerrent.alquilerbicicletas.dto.entrada.modificacion.CategoriaModificacionEntradaDto;
import com.ebikerrent.alquilerbicicletas.dto.entrada.producto.CategoriaEntradaDto;
import com.ebikerrent.alquilerbicicletas.dto.salida.producto.CategoriaSalidaDto;
import com.ebikerrent.alquilerbicicletas.entity.Categoria;
import com.ebikerrent.alquilerbicicletas.repository.CategoriaRepository;
import com.ebikerrent.alquilerbicicletas.service.ICategoriaService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoriaService implements ICategoriaService {

    private final Logger LOGGER = LoggerFactory.getLogger(CategoriaService.class);
    private final CategoriaRepository categoriaRepository;
    private final ModelMapper modelMapper;

    public CategoriaService(CategoriaRepository categoriaRepository, ModelMapper modelMapper) {
        this.categoriaRepository = categoriaRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<CategoriaSalidaDto> listarCategorias() {
        List<Categoria> categorias = categoriaRepository.findAll();
        List<CategoriaSalidaDto> categoriaSalidaDtoList = new ArrayList<>();

        for (Categoria cat: categorias){
            CategoriaSalidaDto categoriaSalidaDto = entidadAdtoSalida(cat);
            categoriaSalidaDtoList.add(categoriaSalidaDto);
        }

        LOGGER.info("Listado de las categorias : " + categorias);
        return categoriaSalidaDtoList;
    }

    @Override
    public CategoriaSalidaDto registrarCategoria(CategoriaEntradaDto categoriaEntradaDto) {
        Categoria categoriaRecibida = dtoEntradaAentidad(categoriaEntradaDto);
        Categoria categoriaRegistrada = categoriaRepository.save(categoriaRecibida);
        CategoriaSalidaDto categoriaResultado = entidadAdtoSalida(categoriaRegistrada);
        LOGGER.info("Categoria registrada: " + categoriaRegistrada);
        return categoriaResultado;
    }

    @Override
    public CategoriaSalidaDto buscarCategoriaPorId(Long id) {

        return null;
    }

    @Override
    public void eliminarCategoria(Long id) {

    }

    @Override
    public CategoriaSalidaDto modificarCategoria(CategoriaModificacionEntradaDto categoriaModificacionEntradaDto) {
        return null;
    }

    public Categoria dtoEntradaAentidad(CategoriaEntradaDto categoriaEntradaDto){
        return modelMapper.map(categoriaEntradaDto, Categoria.class);
    }

    public CategoriaSalidaDto entidadAdtoSalida(Categoria categoria){
        return modelMapper.map(categoria, CategoriaSalidaDto.class);
    }
    public Categoria dtoSalidaAentidad(CategoriaSalidaDto categoriaSalidaDto){
        return modelMapper.map(categoriaSalidaDto, Categoria.class);
    }
    public Categoria dtoModificadoAentidad(CategoriaModificacionEntradaDto categoriaModificacionEntradaDto){
        return modelMapper.map(categoriaModificacionEntradaDto, Categoria.class);
    }

}

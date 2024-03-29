package com.ebikerrent.alquilerbicicletas.service.impl;

import com.ebikerrent.alquilerbicicletas.dto.entrada.caracteristica.CaracteristicaEntradaDto;
import com.ebikerrent.alquilerbicicletas.dto.entrada.modificacion.CaracteristicaModificacionEntradaDto;
import com.ebikerrent.alquilerbicicletas.dto.salida.caracteristica.CaracteristicaSalidaDto;
import com.ebikerrent.alquilerbicicletas.entity.Caracteristica;
import com.ebikerrent.alquilerbicicletas.exceptions.ResourceNotFoundException;
import com.ebikerrent.alquilerbicicletas.repository.CaracteristicaRepository;
import com.ebikerrent.alquilerbicicletas.repository.ProductoRepository;
import com.ebikerrent.alquilerbicicletas.service.ICaracteristicaService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class CaracteristicaService implements ICaracteristicaService {
    private final Logger LOGGER = LoggerFactory.getLogger(CategoriaService.class);
    private final ModelMapper modelMapper;

    private final CaracteristicaRepository caracteristicaRepository;
    private final ProductoRepository productoRepository;

    @Override
    public CaracteristicaSalidaDto registrarCaracteristica(CaracteristicaEntradaDto caracteristicaEntradaDto) throws ResourceNotFoundException {
        if (caracteristicaRepository.findByNombre(caracteristicaEntradaDto.getNombre())!=null){
            LOGGER.info("Existe una categoria con ese mismo nombre :" + caracteristicaRepository.findByNombre(caracteristicaEntradaDto.getNombre()));
            throw new ResourceNotFoundException("Existe una caracteristica con el mismo nombre");
        }
        Caracteristica caracteristicaRecibida= dtoEntradaAentidad(caracteristicaEntradaDto);
        Caracteristica caracteristicaRegistrada= caracteristicaRepository.save(caracteristicaRecibida);
        CaracteristicaSalidaDto caracteristicaResultado= entidadAdtoSalida(caracteristicaRegistrada);
        LOGGER.info("Caracteristica registrada: " + caracteristicaRegistrada);
        return caracteristicaResultado;
    }
    @Override
    public List<CaracteristicaSalidaDto> listarCaracteristicas() {
        List<Caracteristica> caracteristicas = caracteristicaRepository.findAll();
        List<CaracteristicaSalidaDto> caracteristicaSalidaDtosList= new ArrayList<>();

        for (Caracteristica car: caracteristicas){
            CaracteristicaSalidaDto caracteristicaSalidaDto = entidadAdtoSalida(car);
            caracteristicaSalidaDtosList.add(caracteristicaSalidaDto);
        }
        LOGGER.info("Listado de todas las caracteristicas:" + caracteristicas);
        return caracteristicaSalidaDtosList;
    }
    @Override
    public CaracteristicaSalidaDto buscarCaracteristicaPorId(Long id) {
        Caracteristica caracteristicaBuscada = caracteristicaRepository.findById(id).orElse(null);

        CaracteristicaSalidaDto caracteristicaEncontrada = null;
        if (caracteristicaBuscada!= null){
            caracteristicaEncontrada= entidadAdtoSalida(caracteristicaBuscada);
            LOGGER.info("Caracteristica encontrada: " + caracteristicaBuscada);
        }else
            LOGGER.error("El id de la caracteristica no se encuentra en la base de datos");

        return caracteristicaEncontrada;
    }

    /*@Override
    public void eliminarCaracteristica(Long id) throws ResourceNotFoundException {
        Caracteristica buscarCaracteristica = caracteristicaRepository.findById(id).orElse(null);

        if(buscarCaracteristica == null){
            LOGGER.info("La caracteristica con ID: " + id + " no se encontro en la base de datos");
            throw new ResourceNotFoundException("La caracteristica con ID: " + id + " no se encontro en la base de datos");
        }
        caracteristicaRepository.deleteById(id);
        LOGGER.info("Se elimino la caracteristica con ID: " + id);
    }*/


    @Override
    public CaracteristicaSalidaDto modificarCaracteristica(CaracteristicaModificacionEntradaDto caracteristicaModificacionEntradaDto) {
        return null;
    }


    public Caracteristica dtoEntradaAentidad(CaracteristicaEntradaDto caracteristicaEntradaDto){
        return modelMapper.map(caracteristicaEntradaDto, Caracteristica.class);
    }

    public CaracteristicaSalidaDto entidadAdtoSalida(Caracteristica caracteristica){
        return modelMapper.map(caracteristica, CaracteristicaSalidaDto.class);
    }
    public Caracteristica dtoSalidaAentidad(CaracteristicaSalidaDto caracteristicaSalidaDto){
        return modelMapper.map(caracteristicaSalidaDto, Caracteristica.class);
    }
    public Caracteristica dtoModificadoAentidad(CaracteristicaModificacionEntradaDto caracteristicaModificacionEntradaDto){
        return modelMapper.map(caracteristicaModificacionEntradaDto, Caracteristica.class);
    }

}

package com.ebikerrent.alquilerbicicletas.service.impl;

import com.ebikerrent.alquilerbicicletas.dto.entrada.modificacion.ProductoModificacionEntradaDto;
import com.ebikerrent.alquilerbicicletas.dto.entrada.producto.ProductoEntradaDto;
import com.ebikerrent.alquilerbicicletas.dto.salida.producto.CategoriaSalidaDto;
import com.ebikerrent.alquilerbicicletas.dto.salida.producto.ProductoSalidaDto;
import com.ebikerrent.alquilerbicicletas.entity.Categoria;
import com.ebikerrent.alquilerbicicletas.entity.Producto;
import com.ebikerrent.alquilerbicicletas.exceptions.ResourceNotFoundException;
import com.ebikerrent.alquilerbicicletas.repository.CategoriaRepository;
import com.ebikerrent.alquilerbicicletas.repository.ProductoRepository;
import com.ebikerrent.alquilerbicicletas.service.IProductoService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class ProductoService implements IProductoService {
    private final Logger LOGGER = LoggerFactory.getLogger(ProductoService.class);
    private final ProductoRepository productoRepository;
    private final ModelMapper modelMapper;
    private final CategoriaRepository categoriaRepository;

    public ProductoService(ProductoRepository productoRepository, ModelMapper modelMapper, CategoriaRepository categoriaRepository) {
        this.productoRepository = productoRepository;
        this.modelMapper = modelMapper;
        this.categoriaRepository = categoriaRepository;
        configuracionMapper();
    }

    @Override
    public ProductoSalidaDto registrarProducto(ProductoEntradaDto productoEntradaDto) throws ResourceNotFoundException {

        if (productoRepository.findByNombre(productoEntradaDto.getNombre()) != null) {
            LOGGER.info("Ya existe un producto con el mismo nombre");
            throw new ResourceNotFoundException("Existe un producto con el mismo nombre");
        }

        String categoriaId = productoEntradaDto.getCategoriaString();
        LOGGER.info("ESTÁ ENTARNDO" + productoEntradaDto.getCategoriaString());

        Categoria categoria = categoriaRepository.findByTitulo(categoriaId);
        if (categoria == null) {
            throw new ResourceNotFoundException("No se encontró la categoría con el nombre proporcionado: " + categoriaId);
        }
                //.orElseThrow(() -> new ResourceNotFoundException("No se encontró la categoría con el ID proporcionado"));
        //Mapear DTO de entrada a entidad Producto
        Producto productRecibido = dtoEntradaAentidad(productoEntradaDto);
        productRecibido.setCategoria(categoria);

        //Guardar el producto en la base de datos
        Producto productoRegistrado = productoRepository.save(productRecibido);

        //Mapear entidad Producto a DTO de salida
        ProductoSalidaDto productoResultado = entidadAdtoSalida(productoRegistrado);


        LOGGER.info("PRODUCTO REGISTRADO : " + productoRegistrado);
        return productoResultado;
    }

    @Override
    public ProductoSalidaDto buscarProductoPorId(Long id) throws ResourceNotFoundException {
        Producto productoBuscado = productoRepository.findById(id).orElse(null);

        ProductoSalidaDto productoEncontrado = null;
        if (productoBuscado != null){
            productoEncontrado = entidadAdtoSalida(productoBuscado);
            LOGGER.info("Producto encontrado : " + productoBuscado);
        }else {
            LOGGER.error("El id del producto no se encuentra en la base de datos");
            throw new ResourceNotFoundException("No se encontró el producto en la base de datos");
        }

       return productoEncontrado;
    }

    @Override
    public void eliminarProducto(Long id) throws ResourceNotFoundException {

    if (buscarProductoPorId(id) != null){
        LOGGER.warn("Se eliminó el producto con el id : " + dtoSalidaAentidad(buscarProductoPorId(id)));
        productoRepository.deleteById(id);
    }else {
        LOGGER.error("No se encontró el producto con el id : " + id);
        throw new ResourceNotFoundException("No se encontró el producto con el id : " + id);
    }

    }

    @Override
    public ProductoSalidaDto modificarProducto(ProductoModificacionEntradaDto productoModificacionEntradaDto) throws ResourceNotFoundException {

        String categoriaTitulo = productoModificacionEntradaDto.getTituloCategoria();

        Categoria categoria = categoriaRepository.findByTitulo(categoriaTitulo);
        if (categoria == null) {
            throw new ResourceNotFoundException("No se encontró la categoría con el nombre proporcionado: " + categoriaTitulo);
        }

        Producto productoAmodificar = dtoModificacioAentidad(productoModificacionEntradaDto);
        productoAmodificar.setCategoria(categoria);

        Producto productoPorID = buscarProductoPorId(productoAmodificar.getId());

        ProductoSalidaDto productoSalidaDtoModificado = null;

            if (productoPorID !=null){
                Producto productoModificado = productoRepository.save(productoAmodificar);
                productoSalidaDtoModificado = entidadAdtoSalida((productoModificado));
                LOGGER.info("Producto Modificado : " + productoModificado);
            }else {
                LOGGER.error("El producto no se encontró");
                throw new ResourceNotFoundException("No fue posible actualizar los datos del producto ");
            }

        return productoSalidaDtoModificado;
    }

    @Override
    public ProductoSalidaDto buscarProductoPorNombre(ProductoEntradaDto productoEntradaDto) throws ResourceNotFoundException {
        String nombreProducto = productoEntradaDto.getNombre();
        Producto productoPorNombre = productoRepository.findByNombre(nombreProducto);

        ProductoSalidaDto productoEncontrado = null;
        if (productoPorNombre!= null){
            productoEncontrado = entidadAdtoSalida(productoPorNombre);
            LOGGER.info("Producto encontrado por nombre : " + productoPorNombre);
        } else{
            LOGGER.info("No se encontró el producto con el nombre : " + nombreProducto);
            throw new ResourceNotFoundException("No se encontró el producto con el nombre : " + nombreProducto);
        }

        return productoEncontrado;
    }



    @Override
    public List<ProductoSalidaDto> listarProductos() {
        List<Producto> productos = productoRepository.findAll();
        LOGGER.info("imagenes : " + productos.get(0).getImagenes()); //mostrar las imágenes del primer producto del listado


        List<ProductoSalidaDto> productoSalidaDtoList= new ArrayList<>();

        for (Producto p: productos){

            ProductoSalidaDto productoSalidaDto = entidadAdtoSalida(p);
            productoSalidaDtoList.add(productoSalidaDto);
        }
        LOGGER.info("Listado de todos los productos : " + productos);

        return productoSalidaDtoList;
    }


    //El método configuracionMapper está utilizando la biblioteca ModelMapper para definir cómo deben realizarse
    //los mapeos entre tres clases relacionadas: ProductoEntradaDto, Producto, y ProductoModificacionEntradaDto.
    //Estos mapeos están específicamente centrados en la propiedad imagen.
    private void configuracionMapper(){
        modelMapper.typeMap(ProductoEntradaDto.class, Producto.class)
                .addMappings(mapper ->
                {
                    mapper.map(ProductoEntradaDto:: getImagenEntradaDtos, Producto::setImagenes);
                    //mapper.map(ProductoEntradaDto:: getCategoriaEntradaDto,Producto::setCategoria);
                });


        modelMapper.typeMap(Producto.class, ProductoSalidaDto.class)
                .addMappings(mapper ->
                {
                    mapper.map(Producto::getImagenes,ProductoSalidaDto::setImagenSalidaDto);
                    mapper.map(Producto::getCategoria,ProductoSalidaDto::setCategoriaSalidaDto);
                });

        /*modelMapper.typeMap(ProductoModificacionEntradaDto.class,Producto.class)
                .addMappings(mapper -> mapper.map(ProductoModificacionEntradaDto::getImagenEntradaDto,Producto::setImagenes));*/

    }
    public Producto dtoEntradaAentidad(ProductoEntradaDto productoEntradaDto){
        /*Producto productoEntidad = modelMapper.map(productoEntradaDto, Producto.class);
        productoEntidad.setCategoria(productoEntradaDto.getCategoriaId());*/
        return modelMapper.map(productoEntradaDto, Producto.class);
    }

    public ProductoSalidaDto entidadAdtoSalida(Producto producto){
        return modelMapper.map(producto, ProductoSalidaDto.class);
    }
    public Producto dtoSalidaAentidad (ProductoSalidaDto productoSalidaDto){
        return modelMapper.map(productoSalidaDto, Producto.class);
    }

    public Producto dtoModificacioAentidad (ProductoModificacionEntradaDto productoModificacionEntradaDto){
        return modelMapper.map(productoModificacionEntradaDto,Producto.class);
    }

}

package com.ebikerrent.alquilerbicicletas.repository;

import com.ebikerrent.alquilerbicicletas.entity.Categoria;
import com.ebikerrent.alquilerbicicletas.entity.Imagen;
import com.ebikerrent.alquilerbicicletas.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductoRepository extends JpaRepository<Producto,Long> {
    Producto findByNombre(String nombre);

    List<Producto> findAllByNombreContaining(String nombre);

    List<Producto> findAllByCategoria(Categoria categoria);
}
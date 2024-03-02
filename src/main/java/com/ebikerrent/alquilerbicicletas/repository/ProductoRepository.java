package com.ebikerrent.alquilerbicicletas.repository;

import com.ebikerrent.alquilerbicicletas.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends JpaRepository<Producto,Long> {
    // Optional<List<Producto>> findAllByUbicacionId(Long id);
    // Optional<List<Producto>> findAllByCategoriaId(Long id);
    //Optional<List<Producto>> findProductoXFechas(LocalDate fechaInicio, LocalDate fechaFinal, Long id)
    Producto findByNombre(String nombre);
}

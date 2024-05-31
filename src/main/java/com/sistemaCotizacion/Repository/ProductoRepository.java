package com.sistemaCotizacion.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sistemaCotizacion.Entity.Producto;

public interface ProductoRepository  extends JpaRepository<Producto, Integer>{
	
	Optional<Producto> findBySku(String sku);
	List<Producto> findByNombreContaining(String nombre);

}

package com.sistemaCotizacion.Logic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistemaCotizacion.Entity.Producto;
import com.sistemaCotizacion.Repository.ProductoRepository;

@Service
public class ProductoLogic {

	@Autowired
	public ProductoRepository productoRepository;
	
	public Producto agregarProducto(Producto producto) {
		return productoRepository.save(producto);
	}
	
	public Producto actualizarProducto(int id, Producto producto) {
		Producto productoExistente = productoRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Producto no encontrado"));
		
		productoExistente.setSku(producto.getSku());
		productoExistente.setNombre(producto.getNombre());
		productoExistente.setPrecio(producto.getPrecio());
		return productoRepository.save(productoExistente);
	}
	
	public void eliminarProducto(int id) {
		productoRepository.deleteById(id);
	}
	
	public List<Producto> buscarProducto(String sku, String nombre){
		if(sku != null && !sku.isEmpty()) {
			return productoRepository.findBySku(sku).map(List::of).orElse(List.of());
		}else if(nombre != null && !nombre.isEmpty()) {
			return productoRepository.findByNombreContaining(nombre);
		}
		return List.of();		
	}
	
	
	public List<Producto> listarProductos(){
		return productoRepository.findAll();
		}
	
}

package com.sistemaCotizacion.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sistemaCotizacion.Entity.Producto;
import com.sistemaCotizacion.Logic.ProductoLogic;

@RestController
@RequestMapping("/productos")
public class ProductoController {
    @Autowired
    private ProductoLogic productoService;

    @PostMapping
    public ResponseEntity<Producto> agregarProducto(@RequestBody Producto producto) {
        return ResponseEntity.ok(productoService.agregarProducto(producto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Producto> actualizarProducto(@PathVariable int id, @RequestBody Producto producto) {
        return ResponseEntity.ok(productoService.actualizarProducto(id, producto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarProducto(@PathVariable int id) {
        productoService.eliminarProducto(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<Producto>> buscarProductos(@RequestParam(required = false) String sku,
                                                           @RequestParam(required = false) String nombre) {
        return ResponseEntity.ok(productoService.buscarProducto(sku, nombre));
    }

    @GetMapping("/todos")
    public ResponseEntity<List<Producto>> listarProductos(){
    	return ResponseEntity.ok(productoService.listarProductos());
    }
}


package com.sistemaCotizacion.Controller;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sistemaCotizacion.Entity.Plazo;
import com.sistemaCotizacion.Entity.Producto;
import com.sistemaCotizacion.Logic.CotizacionLogic;
import com.sistemaCotizacion.Logic.PlazoLogic;
import com.sistemaCotizacion.Logic.ProductoLogic;

@RestController
@RequestMapping("/cotizaciones")


public class CotizacionController {
	
	@Autowired
	public ProductoLogic productoService;
	
	@Autowired
    public PlazoLogic plazoService;

	@Autowired
    public CotizacionLogic cotizacionService;

	
	@GetMapping("/producto/{sku}")
    public ResponseEntity<Producto> obtenerProducto(@PathVariable String sku) {
        return productoService.buscarProducto(sku, null).stream().findFirst()
                .map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

	
	@GetMapping("/plazos")
    public ResponseEntity<List<Plazo>> listarPlazos() {
        return ResponseEntity.ok(plazoService.listarPlazos());
    }

	
	@PostMapping("/cotizar")
	public ResponseEntity<Map<String, BigDecimal>> cotizarCredito(@RequestParam String sku, @RequestParam int plazoId){
		 Producto producto = productoService.buscarProducto(sku, null).stream().findFirst()
	                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));

		 Plazo plazo = plazoService.listarPlazos().stream().filter(p -> p.getId_plazo() == plazoId)
	                .findFirst().orElseThrow(() -> new RuntimeException("Plazo no encontrado"));
		 
		 BigDecimal abonoNormal = cotizacionService.calcularAbonoNormal(producto.getPrecio(), plazo.getTasaNormal(), plazo.getSemanas());
		 BigDecimal abonoPuntual = cotizacionService.calcularAbonoPuntual(producto.getPrecio(), plazo.getTasaPuntual(), plazo.getSemanas());

		 
		 Map<String, BigDecimal> respuesta = new HashMap<>();

		 
		 respuesta.put("abonoNormal", abonoNormal);

		 
		 respuesta.put("abonoPuntual", abonoPuntual);

		 return ResponseEntity.ok(respuesta);



	}

	

}

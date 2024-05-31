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
import org.springframework.web.bind.annotation.RestController;

import com.sistemaCotizacion.Entity.Plazo;
import com.sistemaCotizacion.Logic.PlazoLogic;

@RestController
@RequestMapping("/plazos")
public class PlazoController {
    @Autowired
    private PlazoLogic plazoService;

    @PostMapping
    public ResponseEntity<Plazo> agregarPlazo(@RequestBody Plazo plazo) {
        return ResponseEntity.ok(plazoService.agregarPlazo(plazo));
    }

    @PutMapping("/{id_plazo}")
    public ResponseEntity<Plazo> actualizarPlazo(@PathVariable int id_plazo, @RequestBody Plazo plazo) {
        return ResponseEntity.ok(plazoService.actualizarPlazo(id_plazo, plazo));
    }

    @DeleteMapping("/{id_plazo}")
    public ResponseEntity<Void> eliminarPlazo(@PathVariable int id_plazo) {
        plazoService.eliminarPlazo(id_plazo);
        return ResponseEntity.noContent().build();
    }

    @GetMapping()
    public ResponseEntity<List<Plazo>> listarPlazos(){
    	return ResponseEntity.ok(plazoService.listarPlazos());
    }
   
}
package com.sistemaCotizacion.Logic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistemaCotizacion.Entity.Plazo;
import com.sistemaCotizacion.Repository.PlazoRepository;


@Service
public class PlazoLogic{

	@Autowired
	PlazoRepository plazoRepository;
	
	public Plazo agregarPlazo(Plazo plazo) {
		return plazoRepository.save(plazo);
	}
	
	public Plazo actualizarPlazo(int id_plazo, Plazo plazo) {
		Plazo plazoExistente = plazoRepository.findById(id_plazo)
				.orElseThrow(() -> new RuntimeException("Plazo no encontrado"));
		plazoExistente.setId_plazo(plazo.getId_plazo());
		plazoExistente.setSemanas(plazo.getSemanas());
		plazoExistente.setTasaNormal(plazo.getTasaNormal());
		plazoExistente.setTasaPuntual(plazo.getTasaPuntual());
		return plazoRepository.save(plazoExistente);
				
	}
	
	public void eliminarPlazo(int id_plazo) {
		plazoRepository.deleteById(id_plazo);
	}
	
	public List<Plazo> listarPlazos(){
		return plazoRepository.findAll();
	}
	
	
}

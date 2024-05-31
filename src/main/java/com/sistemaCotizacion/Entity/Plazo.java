package com.sistemaCotizacion.Entity;

import java.io.Serializable;
import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="plazo")
public class Plazo implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="id_p", columnDefinition="NUMBER")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int id_plazo;
	
	@Column(name="semanas", columnDefinition="NUMBER")
	int semanas;
	
	@Column(name="tasaNormal", columnDefinition="NUMBER")
	BigDecimal tasaNormal;
	
	@Column(name="tasaPuntual", columnDefinition="NUMBER")
	BigDecimal tasaPuntual;

	public int getId_plazo() {
		return id_plazo;
	}

	public void setId_plazo(int id_plazo) {
		this.id_plazo = id_plazo;
	}

	public int getSemanas() {
		return semanas;
	}

	public void setSemanas(int semanas) {
		this.semanas = semanas;
	}

	public BigDecimal getTasaNormal() {
		return tasaNormal;
	}

	public void setTasaNormal(BigDecimal tasaNormal) {
		this.tasaNormal = tasaNormal;
	}

	public BigDecimal getTasaPuntual() {
		return tasaPuntual;
	}

	public void setTasaPuntual(BigDecimal tasaPuntual) {
		this.tasaPuntual = tasaPuntual;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	

}

package com.sistemaCotizacion.Request;

import java.math.BigDecimal;

public class PlazoRequest {
	int id_plazo;
	int semanas;
	BigDecimal tasaNormal;
	BigDecimal tasaPuntual;
	public PlazoRequest(int id_plazo, int semanas, BigDecimal tasaNormal, BigDecimal tasaPuntual) {
		super();
		this.id_plazo = id_plazo;
		this.semanas = semanas;
		this.tasaNormal = tasaNormal;
		this.tasaPuntual = tasaPuntual;
	}
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
	@Override
	public String toString() {
		return "PlazoRequest [id_plazo=" + id_plazo + ", semanas=" + semanas + ", tasaNormal=" + tasaNormal
				+ ", tasaPuntual=" + tasaPuntual + "]";
	}
	
	

}

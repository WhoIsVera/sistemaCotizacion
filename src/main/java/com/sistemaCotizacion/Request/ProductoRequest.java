package com.sistemaCotizacion.Request;

import java.math.BigDecimal;

public class ProductoRequest {
	
	int id;
	String sku;
	String nombre;
	BigDecimal precio;
	
	public ProductoRequest(int id, String sku, String nombre, BigDecimal precio) {
		super();
		this.id = id;
		this.sku = sku;
		this.nombre = nombre;
		this.precio = precio;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSku() {
		return sku;
	}
	public void setSku(String sku) {
		this.sku = sku;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public BigDecimal getPrecio() {
		return precio;
	}
	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}
	
	@Override
	public String toString() {
		return "ProductoRequest [id=" + id + ", sku=" + sku + ", nombre=" + nombre + ", precio=" + precio + "]";
	}
	
	
	

}

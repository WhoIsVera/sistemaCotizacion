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
@Table(name="PRODUCTOSPla")
public class Producto implements Serializable {
	
	private static final long serialVersion = 1L;
	
	@Id
	@Column(name="id_p", columnDefinition="NUMBER")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int id;
	
	@Column(unique = true, nullable = false,name="sku", columnDefinition="NVARCHAR2")
	String sku;
	
	@Column( nullable = false, name="nombre", columnDefinition="NVARCHAR2")
	String nombre;
	
	@Column( nullable = false, name="precio", columnDefinition="NUMBER")
	BigDecimal precio;

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

	public static long getSerialversion() {
		return serialVersion;
	}

		
}

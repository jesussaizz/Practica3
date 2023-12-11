package es.unican.ps.practica3.entities;

import java.io.Serializable;

import jakarta.persistence.Entity;

@SuppressWarnings("serial")

@Entity
public class DatosPago implements Serializable{
	
	private int numTarjeta;
	
	private int cvc;
	
	private int mesCaducidad;
	
	private int anoCaducidad;
	
	private TipoTarjeta tipo;
	
	public DatosPago(int numTarjeta, int cvc, int mesCaducidad, int anoCaducidad, TipoTarjeta tipo) {
		this.numTarjeta = numTarjeta;
		this.cvc = cvc;
		this.mesCaducidad = mesCaducidad;
		this.anoCaducidad = anoCaducidad;
		this.tipo = tipo;
	}

	public int getNumTarjeta() {
		return numTarjeta;
	}

	public void setNumTarjeta(int numTarjeta) {
		this.numTarjeta = numTarjeta;
	}

	public int getCvc() {
		return cvc;
	}

	public void setCvc(int cvc) {
		this.cvc = cvc;
	}

	public int getMesCaducidad() {
		return mesCaducidad;
	}

	public void setMesCaducidad(int mesCaducidad) {
		this.mesCaducidad = mesCaducidad;
	}

	public int getAnoCaducidad() {
		return anoCaducidad;
	}

	public void setAnoCaducidad(int anoCaducidad) {
		this.anoCaducidad = anoCaducidad;
	}
	
	
}

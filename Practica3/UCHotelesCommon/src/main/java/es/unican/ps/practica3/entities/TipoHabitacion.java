package es.unican.ps.practica3.entities;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@SuppressWarnings("serial")

@Entity
public class TipoHabitacion implements Serializable{

	@Id
	private String tipo;
	
	private double precioPorNoche;
	
	private int disponibles;

	public TipoHabitacion() {
		
	}
	
	public TipoHabitacion(String tipo, double precioPorNoche, int disponibles) {
		this.tipo = tipo;
		this.precioPorNoche = precioPorNoche;
		this.disponibles = disponibles;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public double getPrecioPorNoche() {
		return precioPorNoche;
	}

	public void setPrecioPorNoche(double precioPorNoche) {
		this.precioPorNoche = precioPorNoche;
	}

	public int getDisponibles() {
		return disponibles;
	}

	public void setDisponibles(int disponibles) {
		this.disponibles = disponibles;
	}
	
	
}

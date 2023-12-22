package es.unican.ps.practica3.entities;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@SuppressWarnings("serial")

@Entity
public class TipoHabitacion implements Serializable{

	@Id
	private String id;
	
	private double precioPorNoche;
	
	private int disponibles;

	public TipoHabitacion(String id, double precioPorNoche, int disponibles) {
		this.id = id;
		this.precioPorNoche = precioPorNoche;
		this.disponibles = disponibles;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

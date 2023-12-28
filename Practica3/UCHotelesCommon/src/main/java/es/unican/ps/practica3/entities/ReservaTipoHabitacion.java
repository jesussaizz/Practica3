package es.unican.ps.practica3.entities;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@SuppressWarnings("serial")

@Entity
public class ReservaTipoHabitacion implements Serializable{

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private int numHabitaciones;
	
	@OneToOne
	@JoinColumn(name="tipoHabitacion_fk")
	private TipoHabitacion tipoHabitacion;

	public ReservaTipoHabitacion() {
		
	}
	
	public ReservaTipoHabitacion(int numHabitaciones, TipoHabitacion tipoHabitacion) {
		this.numHabitaciones = numHabitaciones;
		this.tipoHabitacion = tipoHabitacion;
	}

	public int getNumHabitaciones() {
		return numHabitaciones;
	}

	public void setNumHabitaciones(int numHabitaciones) {
		this.numHabitaciones = numHabitaciones;
	}

	public TipoHabitacion getTipoHabitacion() {
		return tipoHabitacion;
	}

	public void setTipoHabitacion(TipoHabitacion tipoHabitacion) {
		this.tipoHabitacion = tipoHabitacion;
	}
	
	
}

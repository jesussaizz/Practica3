package es.unican.ps.practica3.entities;

import java.io.Serializable;

@SuppressWarnings("serial")
public class ReservaTipoHabitacion implements Serializable{

	private int numHabitaciones;
	
	private TipoHabitacion tipoHabitacion;

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

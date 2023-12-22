package es.unican.ps.practica3.entities;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


@SuppressWarnings("serial")

@Entity
@Table(name="Hoteles")
public class Hotel implements Serializable{
	
	@Id
	private String nombre;
	
	private String direccion;
	
	private String localidad;
	
	@OneToMany
	@JoinColumn(name="hotel_fk")
	private List<Reserva> reservas;
	
	@OneToMany
	@JoinColumn(name="hotel_fk")
	private List<TipoHabitacion> habitaciones;


	public Hotel(String nombre, String direccion, String localidad) {
		this.nombre = nombre;
		this.direccion = direccion;
		this.localidad = localidad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getLocalidad() {
		return localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}
	
	public List<Reserva> getReservas() {
		return reservas;
	}

	public void anhadeReservas(Reserva reserva) {
		this.reservas.add(reserva);
	}

	public List<TipoHabitacion> getHabitaciones() {
		return habitaciones;
	}

	public void anhadeHabitaciones(TipoHabitacion habitacion) {
		this.habitaciones.add(habitacion);
	}
	
}

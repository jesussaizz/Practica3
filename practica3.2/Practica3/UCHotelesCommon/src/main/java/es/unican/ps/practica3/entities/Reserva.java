package es.unican.ps.practica3.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@SuppressWarnings("serial")
public class Reserva implements Serializable{
	
	private int id;
	
	private Date fechaEntrada;
	
	private Date fechaSalida;

	private double importe;
	
	private DatosCliente cliente;
	
	private DatosPago pago;
	
	private List<ReservaTipoHabitacion> reservaTipoHabitaciones;

	public Reserva(int id, Date fechaEntrada, Date fechaSalida, double importe, DatosCliente cliente, DatosPago pago) {
		this.id = id;
		this.fechaEntrada = fechaEntrada;
		this.fechaSalida = fechaSalida;
		this.importe = importe;
		this.cliente = cliente;
		this.pago = pago;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getFechaEntrada() {
		return fechaEntrada;
	}

	public void setFechaEntrada(Date fechaEntrada) {
		this.fechaEntrada = fechaEntrada;
	}

	public Date getFechaSalida() {
		return fechaSalida;
	}

	public void setFechaSalida(Date fechaSalida) {
		this.fechaSalida = fechaSalida;
	}

	public double getImporte() {
		return importe;
	}

	public void setImporte(double importe) {
		this.importe = importe;
	}
	
	public DatosCliente getCliente() {
		return cliente;
	}

	public void setCliente(DatosCliente cliente) {
		this.cliente = cliente;
	}

	public DatosPago getPago() {
		return pago;
	}

	public void setPago(DatosPago pago) {
		this.pago = pago;
	}

	public List<ReservaTipoHabitacion> getReservaTipoHabitaciones() {
		return reservaTipoHabitaciones;
	}
	
	public void anhadeReservaTipoHabitaciones(ReservaTipoHabitacion reservaTipoHabitaciones) {
		this.reservaTipoHabitaciones.add(reservaTipoHabitaciones);
	}
}

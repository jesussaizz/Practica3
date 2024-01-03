package es.unican.ps.practica3.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@SuppressWarnings("serial")

@Entity
@Table(name="Reservas")
public class Reserva implements Serializable{
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Temporal(TemporalType.DATE)
	private Date fechaEntrada;
	
	@Temporal(TemporalType.DATE)
	private Date fechaSalida;

	private double importe;
	
	@ManyToOne
	@JoinColumn(name="cliente_fk")
	private DatosCliente cliente;
	
	@ManyToOne
	@JoinColumn(name="tarjeta_fk")
	private DatosPago pago;
	
	@OneToMany
	@JoinColumn(name="reserva_fk")
	private List<ReservaTipoHabitacion> reservaTipoHabitaciones;

	public Reserva() {
		
	}
	
	public Reserva(Date fechaEntrada, Date fechaSalida, DatosCliente cliente, DatosPago pago, List<ReservaTipoHabitacion> r) {
		this.fechaEntrada = fechaEntrada;
		this.fechaSalida = fechaSalida;
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

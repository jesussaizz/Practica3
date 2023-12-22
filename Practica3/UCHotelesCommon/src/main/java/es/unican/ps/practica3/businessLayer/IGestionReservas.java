package es.unican.ps.practica3.businessLayer;

import java.sql.Date;
import java.util.List;

import es.unican.ps.practica3.entities.*;
import jakarta.ejb.Local;

@Local
public interface IGestionReservas {
	public int reservar(List<ReservaTipoHabitacion> tipos, Date ini, Date fin, DatosCliente cliente, DatosPago pago, Hotel h);
	public Reserva modificarReserva(Reserva reserva);
	public Reserva consultarReserva(int id);
	public boolean cancelarReserva(Reserva reserva);
	public List<Reserva> consultarReservas(Date ini, Date fin);
}

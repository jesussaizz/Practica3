package es.unican.ps.practica3.businessLayer;

import java.sql.Date;
import java.util.List;

import es.unican.ps.practica3.entities.*;

public interface IGestionReservas {
	public int reservar(List<TipoHabitacion> tipos, int[] numero, DatosCliente cliente, DatosPago pago);
	public Reserva modificarReserva(Reserva reserva);
	public Reserva consultarReserva(int id);
	public boolean cancelarReserva(Reserva reserva);
	public List<Reserva> consultarReservas(Date ini, Date fin);
}

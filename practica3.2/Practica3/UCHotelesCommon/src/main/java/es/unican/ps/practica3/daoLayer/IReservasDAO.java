package es.unican.ps.practica3.daoLayer;

import java.util.List;

import es.unican.ps.practica3.entities.Reserva;
import jakarta.ejb.Local;

@Local
public interface IReservasDAO {
	public Reserva getReserva(int id);
	public boolean creaReserva(Reserva reserva);
	public boolean modificarReserva(Reserva reserva);
	public boolean eliminarReserva(Reserva reserva);
	public List<Reserva> getReservas();
}

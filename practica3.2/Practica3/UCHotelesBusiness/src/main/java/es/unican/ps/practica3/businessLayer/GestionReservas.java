package es.unican.ps.practica3.businessLayer;

import java.sql.Date;
import java.util.List;

import es.unican.ps.practica3.daoLayer.IReservasDAO;
import es.unican.ps.practica3.entities.DatosCliente;
import es.unican.ps.practica3.entities.DatosPago;
import es.unican.ps.practica3.entities.Reserva;
import es.unican.ps.practica3.entities.TipoHabitacion;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;

@Stateless
public class GestionReservas implements IGestionReservas{
	
	@EJB
	private IReservasDAO reservasDAO;

	@Override
	public int reservar(List<TipoHabitacion> tipos, int[] numero, DatosCliente cliente, DatosPago pago) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Reserva modificarReserva(Reserva reserva) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Reserva consultarReserva(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean cancelarReserva(Reserva reserva) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Reserva> consultarReservas(Date ini, Date fin) {
		// TODO Auto-generated method stub
		return null;
	}

}

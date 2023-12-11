package es.unican.ps.practica3.businessLayer;

import java.sql.Date;
import java.util.List;

import es.unican.ps.practica3.daoLayer.IHotelesDAO;
import es.unican.ps.practica3.daoLayer.IReservasDAO;
import es.unican.ps.practica3.entities.DatosCliente;
import es.unican.ps.practica3.entities.DatosPago;
import es.unican.ps.practica3.entities.Hotel;
import es.unican.ps.practica3.entities.Reserva;
import es.unican.ps.practica3.entities.ReservaTipoHabitacion;
import es.unican.ps.practica3.entities.TipoHabitacion;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;


@Stateless
public class GestionReservas implements IGestionReservas{
	
	@EJB
	private IReservasDAO reservasDAO;

	@Override
	public int reservar(List<ReservaTipoHabitacion> tipos, Date ini, Date fin, DatosCliente cliente, DatosPago pago) {		
		 
		 //Guardar reserva
		 Reserva res = new Reserva(ini, fin, cliente, pago, tipos);
		 reservasDAO.creaReserva(res);
		 
		 //Mostrar identificador de la reserva
         System.out.println(res.getId());

         return res.getId();
	}
	
	@Override
	public Reserva modificarReserva(Reserva reserva) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Reserva consultarReserva(int id) {
		// TODO Auto-generated method stub
		return reservasDAO.getReserva(id);
	}

	@Override
	public boolean cancelarReserva(Reserva reserva) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Reserva> consultarReservas(Date ini, Date fin) {
		// TODO Auto-generated method stub
		return reservasDAO.getReservas();
	}

}

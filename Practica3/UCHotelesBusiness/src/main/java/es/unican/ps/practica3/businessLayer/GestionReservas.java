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
import jakarta.ejb.Remove;
import jakarta.ejb.Stateful;
import jakarta.ejb.Stateless;

@Stateless
public class GestionReservas implements IGestionReservas{
	
	@EJB
	private IReservasDAO reservasDAO;

	@EJB
	private IHotelesDAO hotelesDAO;
	
	//METODO @REMOVE PARA ACABAR LA INTERACCION CON STATEFUL
	//@Remove
	public int reservar(List<ReservaTipoHabitacion> tipos, Date ini, Date fin, DatosCliente cliente, DatosPago pago, Hotel h) {		
		double precio = 0;
		for(ReservaTipoHabitacion r:tipos) {
			precio += r.getTipoHabitacion().getPrecioPorNoche() * r.getNumHabitaciones();
		}
		
		//Guardar reserva
		Reserva res = new Reserva(ini, fin, cliente, pago, tipos);
		reservasDAO.creaReserva(res);
		
		h.anhadeReservas(res);
		hotelesDAO.modificarHotel(h);
		
		//Mostrar identificador de la reserva
        System.out.println(res.getId());
        System.out.println(precio);

        return res.getId();
	}
	
	public Reserva modificarReserva(Reserva reserva) {
		// TODO Auto-generated method stub
		return null;
	}

	public Reserva consultarReserva(int id) {
		// TODO Auto-generated method stub
		return reservasDAO.getReserva(id);
	}

	public boolean cancelarReserva(Reserva reserva) {
		// TODO Auto-generated method stub
		return false;
	}

	public List<Reserva> consultarReservas(Date ini, Date fin) {
		// TODO Auto-generated method stub
		return reservasDAO.getReservas();
	}

}

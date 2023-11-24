package es.unican.ps.practica3.businessLayer;

import java.util.Date;
import java.util.List;

import es.unican.ps.practica3.daoLayer.IHotelesDAO;
import es.unican.ps.practica3.entities.Hotel;
import es.unican.ps.practica3.entities.TipoHabitacion;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;

@Stateless
public class GestionHoteles implements IGestionHoteles, IConsultarHabitacion{
	
	@EJB
	private IHotelesDAO hotelesDAO;

	@Override
	public List<Hotel> consultarHoteles() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean modificarPrecio(List<TipoHabitacion> tipos, double precio) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean añadirTipoHabitacion(TipoHabitacion tipo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<TipoHabitacion> consultarDisponibilidad(String parametro, Date ini, Date fin, Hotel hotel) {
		// TODO Auto-generated method stub
		return null;
	}
}

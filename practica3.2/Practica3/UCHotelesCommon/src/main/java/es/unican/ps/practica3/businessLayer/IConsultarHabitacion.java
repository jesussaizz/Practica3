package es.unican.ps.practica3.businessLayer;

import java.util.Date;
import java.util.List;

import es.unican.ps.practica3.entities.*;
import jakarta.ejb.Local;

@Local
public interface IConsultarHabitacion {
	public List<Hotel> consultarDisponibilidad(String nombreHotel, String localidad);
	public List<TipoHabitacion> verDisponibilidad(Hotel h, Date ini, Date fin);
}

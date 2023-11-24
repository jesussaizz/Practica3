package es.unican.ps.practica3.businessLayer;

import java.util.Date;
import java.util.List;

import es.unican.ps.practica3.entities.*;

public interface IConsultarHabitacion {
	public List<TipoHabitacion> consultarDisponibilidad(String parametro, Date ini, Date fin, Hotel hotel);
}

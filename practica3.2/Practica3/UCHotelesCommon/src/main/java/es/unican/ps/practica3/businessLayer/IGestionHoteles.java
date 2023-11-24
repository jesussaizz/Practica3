package es.unican.ps.practica3.businessLayer;

import java.util.List;

import es.unican.ps.practica3.entities.*;


public interface IGestionHoteles {
	public List<Hotel> consultarHoteles();
	public boolean modificarPrecio(List<TipoHabitacion> tipos, double precio);
	public boolean añadirTipoHabitacion(TipoHabitacion tipo);
}

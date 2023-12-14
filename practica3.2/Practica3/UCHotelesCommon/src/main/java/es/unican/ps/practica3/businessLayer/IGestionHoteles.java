package es.unican.ps.practica3.businessLayer;

import java.util.List;

import es.unican.ps.practica3.entities.*;
;
import jakarta.ejb.Local;

@Local
public interface IGestionHoteles {
	public List<Hotel> consultarHoteles();
	public boolean modificarPrecio(List<TipoHabitacion> tipos, double precio);
	public boolean anhadirTipoHabitacion(TipoHabitacion tipo);
}

package es.unican.ps.practica3.daoLayer;

import java.util.ArrayList;
import java.util.List;

import es.unican.ps.practica3.entities.Hotel;
import jakarta.ejb.Local;

@Local
public interface IHotelesDAO {
	public Hotel getHotel(String nombre);
	public List<Hotel> getHoteles();
	public boolean creaHotel(Hotel hotel);
	public boolean modificarHotel(Hotel hotel);
	public boolean eliminarHotel(Hotel hotel);
	public List<Hotel> getHotelesLocalidad(String localidad);
}

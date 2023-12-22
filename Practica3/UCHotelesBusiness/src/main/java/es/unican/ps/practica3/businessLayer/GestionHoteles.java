package es.unican.ps.practica3.businessLayer;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import es.unican.ps.practica3.daoLayer.IHotelesDAO;
import es.unican.ps.practica3.entities.Hotel;
import es.unican.ps.practica3.entities.TipoHabitacion;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateful;
import jakarta.ejb.Stateless;

@Stateless
public class GestionHoteles implements IGestionHoteles, IConsultarHabitacion{
	
	@EJB
	private IHotelesDAO hotelesDAO;

	//EJERCICIO 2 21-22
	//Primero se llama al constructor y luego se inyectan las dependencias, en ese orden
	
	//METODO @REMOVE PARA ACABAR LA INTERACCION CON STATEFUL
	//El remove tambien se puede hacer con un metodo vacio de @Remove
	//cuya unica funcion es acabar la transaccion Stateful
	
	public List<Hotel> consultarHoteles() {
		// TODO Auto-generated method stub
		return hotelesDAO.getHoteles();
	}

	public boolean modificarPrecio(List<TipoHabitacion> tipos, double precio) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean anhadirTipoHabitacion(TipoHabitacion tipo) {
		// TODO Auto-generated method stub
		return false;
	}

	//METODO PRINCIPAL CASO DE USO "CONSULTAR DISPONIBILIDAD"
	public ArrayList<Hotel> consultarDisponibilidad(String nombreHotel, String localidad) {
		ArrayList<Hotel> lista = new ArrayList<Hotel>();
		if (nombreHotel != null) {
			Hotel h2 = (hotelesDAO.getHotel(nombreHotel));
			if(h2 != null) {
				lista.add(h2);
			}
		}
		else if (nombreHotel == null && localidad != null){
			lista = (ArrayList<Hotel>) hotelesDAO.getHotelesLocalidad(localidad);
		}	
		
		return lista;
	}
	//LA INTERFAZ LLAMARÁ A ESTE MÉTODO IDENTIFICANDO LA FILA EN EL XML
	public List<TipoHabitacion> verDisponibilidad(Hotel h, Date ini, Date fin){
		return h.getHabitaciones(); //de momento simpre hay maxima disponibilidad
	}
}

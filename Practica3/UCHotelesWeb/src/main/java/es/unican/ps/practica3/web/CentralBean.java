package es.unican.ps.practica3.web;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import es.unican.ps.practica3.businessLayer.IConsultarHabitacion;
import es.unican.ps.practica3.businessLayer.IGestionHoteles;
import es.unican.ps.practica3.businessLayer.IGestionReservas;
import es.unican.ps.practica3.entities.DatosCliente;
import es.unican.ps.practica3.entities.DatosPago;
import es.unican.ps.practica3.entities.Hotel;
import es.unican.ps.practica3.entities.ReservaTipoHabitacion;
import es.unican.ps.practica3.entities.TipoHabitacion;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

@Named
@RequestScoped
public class CentralBean {
	
	//FACELET CENTRAL.XHTML
	private String localidad;
	private String nombreHotel;
	private List<Hotel> hoteles = new ArrayList<Hotel>();
	
	//FACELET LISTAHOTELES.XHTML
	private String fechaEntrada;
	private String fechaSalida;
	private Hotel hotelPinchado;
	private List<TipoHabitacion> habitaciones = new ArrayList<TipoHabitacion>();
	
	//FACELET DISPONIBILIDAD.XHTML
	private Map<String, String> habitacionReserva = new HashMap<>();
	
	//FACELET DATOSRESERVA.XHTML
	private String nombreReserva;
	private String dniReserva;
	private String numeroTarjetaReserva;
	List<ReservaTipoHabitacion> reservasTipoHabitacion = new ArrayList<>();
	private int codigoReserva;
	
	//GESTION HOTELES
	@EJB
	private IConsultarHabitacion consultarHabitacion;
	@EJB
	private IGestionHoteles gestionHoteles;
	
	//GESTION RESERVAS
	@EJB
	private IGestionReservas gestionReservas;
	
	public CentralBean() {
		
	}
	
	public String buscar() {
		hoteles = consultarHabitacion.consultarDisponibilidad(nombreHotel, localidad);
		return "ListaHoteles.xhtml";
	}
	
	public String verDisponibilidad(Hotel hotel) {
		hotelPinchado = hotel;
		habitaciones = consultarHabitacion.verDisponibilidad(hotel, this.getFechaEntradaDate(), this.getFechaSalidaDate());
		return "Disponibilidad.xhtml";
	}
	
	public String introducirDatosReserva() {
		return "DatosReserva.xhtml";
	}
	
	public String reservar() {
		for (Map.Entry<String, String> entry : habitacionReserva.entrySet()) {
		    String tipoHabitacion = entry.getKey();
		    String cantidadString = entry.getValue();

		    // Convertir la cantidad de habitaciones a un entero
		    int cantidadHabitaciones = Integer.parseInt(cantidadString);

		    // Crear una instancia de ReservaTipoHabitacion y agregarla a la lista
		    ReservaTipoHabitacion reservaTipoHabitacion = new ReservaTipoHabitacion(cantidadHabitaciones, hotelPinchado.obtenerTipoHabitacionPorNombre(tipoHabitacion));
		    reservasTipoHabitacion.add(reservaTipoHabitacion);
		}
		DatosCliente cliente = new DatosCliente();
		cliente.setDni(dniReserva);
		cliente.setNombre(nombreReserva);
		DatosPago tarjeta = new DatosPago();
		tarjeta.setNumTarjeta(Integer.parseInt(numeroTarjetaReserva));
		codigoReserva = gestionReservas.reservar(reservasTipoHabitacion, this.getFechaEntradaDate(), this.getFechaSalidaDate(), cliente, tarjeta, hotelPinchado);
		return "ConfirmacionReserva.xhtml";
	}

	public String cerrarConfirmacion () {
		return "Central.xhtml";
	}
	
    public Date getFechaEntradaDate() {
        return new java.sql.Date(convertirFechaStringADate(fechaEntrada).getTime());
    }

    public Date getFechaSalidaDate() {
        return new java.sql.Date(convertirFechaStringADate(fechaSalida).getTime());
    }

	
	private java.util.Date convertirFechaStringADate(String fechaString) {
        try {
            SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
            return formatoFecha.parse(fechaString);
        } catch (ParseException e) {
            // Manejar la excepción según tus necesidades
            e.printStackTrace();
            return null; // O lanzar una excepción personalizada
        }
    }
	
}

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
	private String nombreReserva = "";
	private String dniReserva = "";
	private String numeroTarjetaReserva = "";
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
	
	private Hotel prueba = new Hotel("Hotel Prueba", "Barrio Prueba", "Santander");
	
	
	public CentralBean() {
		
	}
	
	public String buscar() {
		hoteles = consultarHabitacion.consultarDisponibilidad(nombreHotel, localidad);
		hoteles.add(prueba);
		return "ListaHoteles.xhtml";
	}
	
	public String verDisponibilidad(Hotel hotel) {
		hotelPinchado = hotel;
		habitaciones = consultarHabitacion.verDisponibilidad(hotel, this.getFechaEntradaDate(), this.getFechaSalidaDate());
		//habitaciones = consultarHabitacion.verDisponibilidad(prueba, this.getFechaEntradaDate(), this.getFechaSalidaDate());
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
        return (Date) convertirFechaStringADate(fechaEntrada);
    }

    public Date getFechaSalidaDate() {
        return (Date) convertirFechaStringADate(fechaSalida);
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

	public String getLocalidad() {
		return localidad;
	}

	public String getNombreHotel() {
		return nombreHotel;
	}

	public List<Hotel> getHoteles() {
		return hoteles;
	}

	public String getFechaEntrada() {
		return fechaEntrada;
	}

	public String getFechaSalida() {
		return fechaSalida;
	}

	public Hotel getHotelPinchado() {
		return hotelPinchado;
	}

	public List<TipoHabitacion> getHabitaciones() {
		return habitaciones;
	}

	public Map<String, String> getHabitacionReserva() {
		return habitacionReserva;
	}

	public String getNombreReserva() {
		return nombreReserva;
	}

	public String getDniReserva() {
		return dniReserva;
	}

	public String getNumeroTarjetaReserva() {
		return numeroTarjetaReserva;
	}

	public List<ReservaTipoHabitacion> getReservasTipoHabitacion() {
		return reservasTipoHabitacion;
	}

	public int getCodigoReserva() {
		return codigoReserva;
	}

	public IConsultarHabitacion getConsultarHabitacion() {
		return consultarHabitacion;
	}

	public IGestionHoteles getGestionHoteles() {
		return gestionHoteles;
	}

	public IGestionReservas getGestionReservas() {
		return gestionReservas;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	public void setNombreHotel(String nombreHotel) {
		this.nombreHotel = nombreHotel;
	}

	public void setHoteles(List<Hotel> hoteles) {
		this.hoteles = hoteles;
	}

	public void setFechaEntrada(String fechaEntrada) {
		this.fechaEntrada = fechaEntrada;
	}

	public void setFechaSalida(String fechaSalida) {
		this.fechaSalida = fechaSalida;
	}

	public void setHotelPinchado(Hotel hotelPinchado) {
		this.hotelPinchado = hotelPinchado;
	}

	public void setHabitaciones(List<TipoHabitacion> habitaciones) {
		this.habitaciones = habitaciones;
	}

	public void setHabitacionReserva(Map<String, String> habitacionReserva) {
		this.habitacionReserva = habitacionReserva;
	}

	public void setNombreReserva(String nombreReserva) {
		this.nombreReserva = nombreReserva;
	}

	public void setDniReserva(String dniReserva) {
		this.dniReserva = dniReserva;
	}

	public void setNumeroTarjetaReserva(String numeroTarjetaReserva) {
		this.numeroTarjetaReserva = numeroTarjetaReserva;
	}

	public void setReservasTipoHabitacion(List<ReservaTipoHabitacion> reservasTipoHabitacion) {
		this.reservasTipoHabitacion = reservasTipoHabitacion;
	}

	public void setCodigoReserva(int codigoReserva) {
		this.codigoReserva = codigoReserva;
	}

	public void setConsultarHabitacion(IConsultarHabitacion consultarHabitacion) {
		this.consultarHabitacion = consultarHabitacion;
	}

	public void setGestionHoteles(IGestionHoteles gestionHoteles) {
		this.gestionHoteles = gestionHoteles;
	}

	public void setGestionReservas(IGestionReservas gestionReservas) {
		this.gestionReservas = gestionReservas;
	}
	
	
	
	
}

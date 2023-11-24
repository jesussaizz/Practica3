package es.unican.ps.practica3.entities;

import java.io.Serializable;

@SuppressWarnings("serial")

public class DatosCliente implements Serializable{

	private String dni;
	
	private String nombre;
	
	private String email;
	
	public DatosCliente(String dni, String nombre, String email) {
		this.dni = dni;
		this.nombre = nombre;
		this.email = email;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	

}

package es.unican.ps.practica3.entities;

import java.io.Serializable;

import jakarta.persistence.Entity;

@SuppressWarnings("serial")

@Entity
public enum TipoTarjeta implements Serializable{
	MASTERCARD, VISA, AMERICAN_EXPRESS
}

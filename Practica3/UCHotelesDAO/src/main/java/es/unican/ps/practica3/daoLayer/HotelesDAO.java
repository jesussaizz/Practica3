package es.unican.ps.practica3.daoLayer;

import java.util.List;

import es.unican.ps.practica3.entities.Hotel;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityManager;

@Stateless
public class HotelesDAO implements IHotelesDAO{

	private EntityManager em;
	
	@Override
	public Hotel getHotel(String nombre) {
		// TODO Auto-generated method stub
		return em.find(Hotel.class, nombre);
	}

	@Override
	public List<Hotel> getHoteles() {
		// TODO Auto-generated method stub
		return em.createQuery("SELECT h FROM Hotel h", Hotel.class).getResultList();
	}

	@Override
	public boolean creaHotel(Hotel hotel) {
		// TODO Auto-generated method stub
		try {
			em.persist(hotel);
			return true;
		} catch (EntityExistsException e) {
			return false;
		}
	}

	@Override
	public boolean modificarHotel(Hotel hotel) {
		// TODO Auto-generated method stub
		try {
            em.merge(hotel);
            return true;
        } catch (EntityExistsException e) {
            return false;
        }
	}

	@Override
	public boolean eliminarHotel(Hotel hotel) {
		// TODO Auto-generated method stub
		try {
			em.remove(hotel);
			return true;
		} catch (EntityExistsException e) {
			return false;
		}
	}

	@Override
	public List<Hotel> getHotelesLocalidad(String localidad) {
		// TODO Auto-generated method stub
		String jpql = "SELECT h FROM Hotel h WHERE h.localidad = :localidad";
	    return em.createQuery(jpql, Hotel.class)
	             .setParameter("localidad", localidad)
	             .getResultList();
	}

}

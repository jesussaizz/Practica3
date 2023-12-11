package es.unican.ps.practica3.daoLayer;

import java.util.List;

import es.unican.ps.practica3.entities.Reserva;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityManager;

@Stateless
public class ReservasDAO implements IReservasDAO{

	private EntityManager em;
	
	@Override
	public Reserva getReserva(int id) {
		// TODO Auto-generated method stub
		return em.find(Reserva.class, id);
	}

	@Override
	public boolean creaReserva(Reserva reserva) {
		// TODO Auto-generated method stub
		try {
			em.persist(reserva);
			return true;
		} catch (EntityExistsException e) {
			return false;
		}
	}

	@Override
	public boolean modificarReserva(Reserva reserva) {
		// TODO Auto-generated method stub
		try {
            em.merge(reserva);
            return true;
        } catch (EntityExistsException e) {
            return false;
        }
	}

	@Override
	public boolean eliminarReserva(Reserva reserva) {
		// TODO Auto-generated method stub
		try {
			em.remove(reserva);
			return true;
		} catch (EntityExistsException e) {			
			return false;
		}
	}

	@Override
	public List<Reserva> getReservas() {
		// TODO Auto-generated method stub
		return em.createQuery("SELECT r FROM Reserva r", Reserva.class).getResultList();
	}

}

package es.unican.ps.practica3.daoLayer;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import es.unican.ps.practica3.entities.Hotel;
import jakarta.persistence.EntityManager;

class HotelesDAOTest {

	@InjectMocks
    private HotelesDAO hotelesDAO;

    @Mock
    private EntityManager entityManager;


	
	@BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        // Puedes inicializar mocks adicionales o configurar comportamientos específicos aquí.
    }

    @Test
    public void testGetHotelNombreExistente() {
        
        String nombreHotel = "HotelExistente";
        Hotel hotelMock = new Hotel(nombreHotel, "Barrio Padierne", "Santander");
        when(entityManager.find(eq(Hotel.class), eq(nombreHotel))).thenReturn(hotelMock);

        Hotel result = hotelesDAO.getHotel(nombreHotel);
  
        assertNotNull(result);
        assertEquals(nombreHotel, result.getNombre());
    }

    @Test
    public void testGetHotelNombreNoExistente() {
        String nombreHotel = "HotelInexistente";
        when(entityManager.find(eq(Hotel.class), eq(nombreHotel))).thenReturn(null);
        
        Hotel result = hotelesDAO.getHotel(nombreHotel);

        assertNull(result);
    }

}

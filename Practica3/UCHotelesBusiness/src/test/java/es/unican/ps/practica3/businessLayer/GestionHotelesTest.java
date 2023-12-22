package es.unican.ps.practica3.businessLayer;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import es.unican.ps.practica3.daoLayer.IHotelesDAO;
import es.unican.ps.practica3.entities.Hotel;



class GestionHotelesTest {

	@InjectMocks
    private GestionHoteles gestionHoteles = new GestionHoteles();

    @Mock
    private IHotelesDAO hotelesDAOMock;
    
    private Hotel h;
    private Hotel h2;

    @BeforeEach
    public void setUp() {
        // Inicializar mocks
    	MockitoAnnotations.openMocks(this);   
    	try {
    		h = new Hotel("NombreValido", "Barrio Padierne", "Santander");
    		h2 = new Hotel("NombreValido2", "Barrio Padierne2", "Santander2");
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    }

    @Test
    public void testConsultarDisponibilidadPorNombreCorrecto() {
        // Configurar el comportamiento del mock
        when(hotelesDAOMock.getHotel("NombreValido")).thenReturn(h);

        // Llamar al método bajo prueba
        ArrayList<Hotel> resultado = gestionHoteles.consultarDisponibilidad("NombreValido", null);

        // Verificar el resultado
        assertNotNull(resultado);
        assertEquals(1, resultado.size());
        assertEquals(h, resultado.get(0));
    }
    
    @Test
    public void testConsultarDisponibilidadPorNombreInexistente() {
        // Configurar el comportamiento del mock para devolver null (hotel no encontrado)
        when(hotelesDAOMock.getHotel("NombreInexistente")).thenReturn(null);

        // Llamar al método bajo prueba
        List<Hotel> resultado = gestionHoteles.consultarDisponibilidad("NombreInexistente", null);

        // Verificar el resultado
        assertNotNull(resultado);
        assertTrue(resultado.isEmpty());
    }
    	
    @Test
    public void testConsultarDisponibilidadPorLocalidadConHoteles() {
        // Configurar el comportamiento del mock para devolver una lista de hoteles
        List<Hotel> hotelesEnLocalidad = new ArrayList<Hotel>();
        hotelesEnLocalidad.add(h);
        hotelesEnLocalidad.add(h2);
        when(hotelesDAOMock.getHotelesLocalidad("LocalidadConHoteles")).thenReturn(hotelesEnLocalidad);

        // Llamar al método bajo prueba
        List<Hotel> resultado = gestionHoteles.consultarDisponibilidad(null, "LocalidadConHoteles");

        // Verificar el resultado
        assertNotNull(resultado);
        assertEquals(2, resultado.size());
    }
    
    @Test
    public void testConsultarDisponibilidadPorLocalidadSinHoteles() {
        // Configurar el comportamiento del mock para devolver una lista vacía (sin hoteles)
    	List<Hotel> hotelesEnLocalidad = new ArrayList<Hotel>();
        when(hotelesDAOMock.getHotelesLocalidad("LocalidadSinHoteles")).thenReturn(hotelesEnLocalidad);

        // Llamar al método bajo prueba
        List<Hotel> resultado = gestionHoteles.consultarDisponibilidad(null, "LocalidadSinHoteles");

        // Verificar el resultado
        assertNotNull(resultado);
        assertTrue(resultado.isEmpty());
    }
    
    @Test
    public void testConsultarDisponibilidadPorLocalidadInexistente() {
        // Configurar el comportamiento del mock para devolver una lista vacía (sin hoteles)
    	List<Hotel> hotelesEnLocalidad = new ArrayList<Hotel>();
        when(hotelesDAOMock.getHotelesLocalidad("LocalidadInexistente")).thenReturn(hotelesEnLocalidad);

        // Llamar al método bajo prueba
        List<Hotel> resultado = gestionHoteles.consultarDisponibilidad(null, "LocalidadInexistente");

        // Verificar el resultado
        assertNotNull(resultado);
        assertTrue(resultado.isEmpty());
    }
	
}

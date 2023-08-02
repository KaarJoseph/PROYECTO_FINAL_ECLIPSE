package ups.edu.ec.proyecto.Negocio;

import java.sql.Timestamp;

import jakarta.annotation.PostConstruct;
import jakarta.ejb.Singleton;
import jakarta.ejb.Startup;
import jakarta.inject.Inject;

import ups.edu.ec.proyecto.Datos.VehiculoDao;
import ups.edu.ec.proyecto.Datos.PersonaDao;
import ups.edu.ec.proyecto.Datos.EspacioDao;
import ups.edu.ec.proyecto.Datos.CabeceraDao;
import ups.edu.ec.proyecto.Datos.DetalleDao;
import ups.edu.ec.proyecto.Modelo.Vehiculo;
import ups.edu.ec.proyecto.Modelo.Persona;
import ups.edu.ec.proyecto.Modelo.Espacio;
import ups.edu.ec.proyecto.Modelo.Cabecera;
import ups.edu.ec.proyecto.Modelo.Detalle;

@Singleton
@Startup
public class DatosDemo {

    @Inject
    private VehiculoDao daoVehiculo;

    @Inject
    private PersonaDao daoPersona;

    @Inject
    private EspacioDao daoEspacio;

    @Inject
    private DetalleDao daoDetalle;
    
    @Inject
    private CabeceraDao daoCabecera;

    @PostConstruct
    public void init() {
        System.out.println("** PERSONAS ***");

        // Ingresar datos de personas (si es necesario)
        Persona persona1 = new Persona();
        persona1.setCedula("1234567890");
        persona1.setNombre("John Doe");
        persona1.setDireccion("123 Main St");
        daoPersona.insert(persona1);
        
        // Ingresar datos de vehículos
        System.out.println("** VEHICULOS ***");

        Vehiculo vehiculo1 = new Vehiculo();
        vehiculo1.setPlaca("ABC-123");
        vehiculo1.setMarca("Toyota");
        vehiculo1.setModelo("Corolla");
        vehiculo1.setTipo("Sedán");
        vehiculo1.setPropietario(persona1);
        daoVehiculo.insert(vehiculo1);

        // Ingresar datos de espacios (si es necesario)
        System.out.println("** ESPACIOS ***");

        Espacio espacio1 = new Espacio();
        espacio1.setNumEspacio(1);
        espacio1.setEstado("Disponible");
        espacio1.setCosto(20.0);
        daoEspacio.insert(espacio1);


	     // Ingresar datos de cabeceras
	     System.out.println("** CABECERAS ***");
	
	     Cabecera cabecera1 = new Cabecera();
	     cabecera1.setTicketInt(1); // Asigna un valor único para el ID de la cabecera manualmente
	     cabecera1.setNumTicket("TICKET-001");
	     cabecera1.setFechaEmision(new Timestamp(System.currentTimeMillis()));
	     cabecera1.setCostoTotal(50.0);
	     cabecera1.setEstado("Pendiente");
	     cabecera1.setPropietarioCabecera(persona1);
	
	     System.out.println("** DETALLES ***");
	
	     // Persistir el objeto Detalle antes de asociarlo a la cabecera
	     Detalle detalle1 = new Detalle();
	     detalle1.setDetalleId(1); // Asigna un valor único para el ID del detalle manualmente
	     detalle1.setFechaIngreso(new Timestamp(System.currentTimeMillis()));
	     detalle1.setFechaSalida(new Timestamp(System.currentTimeMillis() + 3600000)); // Hora de salida dentro de una hora
	     detalle1.setCosto(20.0);
	     detalle1.setEspacio(espacio1);
	     detalle1.setVehiculo(vehiculo1);
	     detalle1.setCabecera(cabecera1);
	     daoDetalle.insert(detalle1); // Reemplaza daoDetalle con el nombre correcto de tu DAO para Detalle
	
	     //cabecera1.addDetalle(detalle1);
	
	     // Persistir el objeto Detalle antes de asociarlo a la cabecera
	     Detalle detalle2 = new Detalle();
	     detalle2.setDetalleId(2); // Asigna un valor único para el ID del detalle manualmente
	     detalle2.setFechaIngreso(new Timestamp(System.currentTimeMillis()));
	     detalle2.setFechaSalida(new Timestamp(System.currentTimeMillis() + 7200000)); // Hora de salida dentro de dos horas
	     detalle2.setCosto(30.0);
	     detalle2.setEspacio(espacio1);
	     detalle2.setVehiculo(vehiculo1);
	     detalle2.setCabecera(cabecera1);
	     daoDetalle.insert(detalle2); // Reemplaza daoDetalle con el nombre correcto de tu DAO para Detalle
	
	     //cabecera1.addDetalle(detalle2);
	
	     daoCabecera.insert(cabecera1);

    }
}

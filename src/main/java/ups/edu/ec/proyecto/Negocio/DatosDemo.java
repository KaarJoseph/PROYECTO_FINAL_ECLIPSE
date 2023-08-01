package ups.edu.ec.proyecto.Negocio;

import jakarta.annotation.PostConstruct;
import jakarta.ejb.Singleton;
import jakarta.ejb.Startup;
import jakarta.inject.Inject;
import ups.edu.ec.proyecto.Datos.VehiculoDao;
import ups.edu.ec.proyecto.Modelo.Vehiculo;

@Singleton
@Startup
public class DatosDemo {

	@Inject
	private VehiculoDao daoVehiculo;
	
	@PostConstruct
	public void init() {
		
		System.out.println("** VEHICULOS ***");
		
		Vehiculo v = new Vehiculo();
		v.setPlaca("ABC-123");
		v.setMarca("NOE");
		v.setModelo("NOE");
		v.setTipo("NOE");
		daoVehiculo.insert(v);
		daoVehiculo.imprimirDatos();
	}
}
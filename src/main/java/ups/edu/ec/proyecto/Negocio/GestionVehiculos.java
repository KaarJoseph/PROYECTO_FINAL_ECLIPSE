package ups.edu.ec.proyecto.Negocio;

import java.util.List;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import ups.edu.ec.proyecto.Datos.VehiculoDao;
import ups.edu.ec.proyecto.Modelo.Vehiculo;

@Stateless
public class GestionVehiculos {

	@Inject
	private VehiculoDao daoVehiculo;
	
	public void guardarVehiculos(Vehiculo vehiculo) throws Exception{
		if(!this.isPlacaValida(vehiculo.getPlaca())) 
			throw new Exception("PLACA INCORRECTA");
		
		if (daoVehiculo.read(vehiculo.getPlaca())==null) {
			try {
				daoVehiculo.insert(vehiculo);
			} catch (Exception e) {
				throw new Exception("Error al insertar: "+ e.getMessage());
			}
		}else {
			try {
				daoVehiculo.update(vehiculo);

			} catch (Exception e) {
				throw new Exception("Error al actualizar: "+ e.getMessage());
			}
		}
	}
	
	private boolean isPlacaValida(String placa) {
		return placa.length()==7;
	}
	
	public void guardarVehiculos(String placa, String marca, String modelo, String color) {
		
	}

	public List<Vehiculo> getVehiculos(){
		return daoVehiculo.getAll();
	}
	
	public void eliminarVehiculo(String vehiculoId) {
		daoVehiculo.delete(vehiculoId);
	}
	
}

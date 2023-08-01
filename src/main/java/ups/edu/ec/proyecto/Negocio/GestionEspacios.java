package ups.edu.ec.proyecto.Negocio;

import java.util.List;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import ups.edu.ec.proyecto.Datos.EspacioDao;
import ups.edu.ec.proyecto.Modelo.Espacio;

@Stateless
public class GestionEspacios {

	@Inject
	private EspacioDao daoEspacio;
	
	public void guardarEspacio(Espacio espacio) throws Exception {
		// Validar que el número de espacio sea un valor positivo
		if (espacio.getNumEspacio() <= 0) {
			throw new Exception("El número de espacio debe ser un valor positivo.");
		}
		
		// Validar que el costo sea un valor positivo
		if (espacio.getCosto() <= 0) {
			throw new Exception("El costo debe ser un valor positivo.");
		}
		
		// Aquí puedes agregar más validaciones según tus requerimientos.
		
		// Verificamos si el espacio ya existe en la base de datos.
		if (daoEspacio.read(espacio.getEspacioId()) == null) {
			try {
				daoEspacio.insert(espacio);
			} catch (Exception e) {
				throw new Exception("Error al insertar: " + e.getMessage());
			}
		} else {
			try {
				daoEspacio.update(espacio);
			} catch (Exception e) {
				throw new Exception("Error al actualizar: " + e.getMessage());
			}
		}
	}

	public List<Espacio> getEspacios(){
		return daoEspacio.getAll();
	}
	
	public void eliminarEspacio(int espacioId) {
		daoEspacio.delete(espacioId);
	}
	
}

package ups.edu.ec.proyecto.Negocio;

import java.util.List;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import ups.edu.ec.proyecto.Datos.CabeceraDao;
import ups.edu.ec.proyecto.Modelo.Cabecera;

@Stateless
public class GestionCabeceras {

	@Inject
	private CabeceraDao daoCabecera;
	
	public void guardarCabecera(Cabecera cabecera) throws Exception {
		// Validar que el número de ticket no esté vacío
		if (cabecera.getNumTicket() == null || cabecera.getNumTicket().isEmpty()) {
			throw new Exception("El número de ticket no puede estar vacío.");
		}
		
		// Validar que el costo total sea un valor positivo
		if (cabecera.getCostoTotal() <= 0) {
			throw new Exception("El costo total debe ser un valor positivo.");
		}
				
		// Verificamos si la cabecera ya existe en la base de datos.
		if (daoCabecera.read(cabecera.getTicketInt()) == null) {
			try {
				daoCabecera.insert(cabecera);
			} catch (Exception e) {
				throw new Exception("Error al insertar: " + e.getMessage());
			}
		} else {
			try {
				daoCabecera.update(cabecera);
			} catch (Exception e) {
				throw new Exception("Error al actualizar: " + e.getMessage());
			}
		}
	}

	public List<Cabecera> getCabeceras(){
		return daoCabecera.getAll();
	}
	
	public void eliminarCabecera(int cabeceraId) {
		daoCabecera.delete(cabeceraId);
	}
	
}

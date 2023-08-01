package ups.edu.ec.proyecto.Negocio;

import java.util.List;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import ups.edu.ec.proyecto.Datos.PersonaDao;
import ups.edu.ec.proyecto.Modelo.Persona;

@Stateless
public class GestionClientes {

	@Inject
	private PersonaDao daoPersona;
	
	public void guardarClientes(Persona persona) throws Exception{
		if(!this.isCedulaValida(persona.getCedula())) 
			throw new Exception("CEDULA INCORRECTA");
		
		if (daoPersona.read(persona.getCedula())==null) {
			try {
				daoPersona.insert(persona);
			} catch (Exception e) {
				throw new Exception("Error al insertar: "+ e.getMessage());
			}
		}else {
			try {
				daoPersona.update(persona);

			} catch (Exception e) {
				throw new Exception("Error al actualizar: "+ e.getMessage());
			}
		}
	}
	
	private boolean isCedulaValida(String cedula) {
		return cedula.length()==10;
	}
	
	public void guardarClientes(String cedula, String nombre, String direccion) {
		
	}

	public List<Persona> getClientes(){
		return daoPersona.getAll();
	}
	
	public void eliminarCliente(String cedula) {
		daoPersona.delete(cedula);
	}
	
}

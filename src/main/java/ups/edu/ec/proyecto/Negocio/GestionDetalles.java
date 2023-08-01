package ups.edu.ec.proyecto.Negocio;

import java.util.List;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import ups.edu.ec.proyecto.Datos.DetalleDao;
import ups.edu.ec.proyecto.Modelo.Detalle;

@Stateless
public class GestionDetalles {

	@Inject
	private DetalleDao daoDetalle;
	
	public void guardarDetalle(Detalle detalle) throws Exception {
		// Validar que las fechas de ingreso y salida no sean nulas
		if (detalle.getFechaIngreso() == null || detalle.getFechaSalida() == null) {
			throw new Exception("Las fechas de ingreso y salida no pueden estar vacías.");
		}
		
		// Validar que la fecha de ingreso sea anterior a la fecha de salida
		if (detalle.getFechaIngreso().after(detalle.getFechaSalida())) {
			throw new Exception("La fecha de ingreso debe ser anterior a la fecha de salida.");
		}
		
		// Validar que el costo sea un valor positivo
		if (detalle.getCosto() <= 0) {
			throw new Exception("El costo debe ser un valor positivo.");
		}
		
		// Aquí puedes agregar más validaciones según tus requerimientos.
		
		// Verificamos si el detalle ya existe en la base de datos.
		if (daoDetalle.read(detalle.getDetalleId()) == null) {
			try {
				daoDetalle.insert(detalle);
			} catch (Exception e) {
				throw new Exception("Error al insertar: " + e.getMessage());
			}
		} else {
			try {
				daoDetalle.update(detalle);
			} catch (Exception e) {
				throw new Exception("Error al actualizar: " + e.getMessage());
			}
		}
	}

	public List<Detalle> getDetalles(){
		return daoDetalle.getAll();
	}
	
	public void eliminarDetalle(int detalleId) {
		daoDetalle.delete(detalleId);
	}
	
}

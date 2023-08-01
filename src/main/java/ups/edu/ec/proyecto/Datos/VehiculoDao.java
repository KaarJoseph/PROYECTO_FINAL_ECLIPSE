package ups.edu.ec.proyecto.Datos;

import java.io.Serializable;
import java.util.List;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import ups.edu.ec.proyecto.Modelo.Persona;
import ups.edu.ec.proyecto.Modelo.Vehiculo;

@Stateless
public class VehiculoDao implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@PersistenceContext
	private EntityManager ve;
	
	public void insert(Vehiculo vehiculo) {
		ve.persist(vehiculo);
	}
	
	public void update(Vehiculo vehiculo) {
		ve.merge(vehiculo);
	}
	
	public Vehiculo read(String vehiculoId) {
		Vehiculo v = ve.find(Vehiculo.class, vehiculoId);
		return v;
	}
	
	public void delete(String vehiculoId) {
		Vehiculo v = ve.find(Vehiculo.class, vehiculoId);
		ve.remove(v);
	}
	
	public List<Vehiculo> getAll(){
		String jpql = "SELECT v FROM Vehiculo v";
		Query q = ve.createQuery(jpql);
		return q.getResultList();
	}
	
	public void imprimirDatos() {
	    List<Vehiculo> vehiculos = getAll();
	    
	    for (Vehiculo vehiculo : vehiculos) {
	        System.out.println("vehiculoId: " + vehiculo.getVehiculoId());
	        System.out.println("placa: " + vehiculo.getPlaca());
	        System.out.println("marca: " + vehiculo.getMarca());
	        System.out.println("modelo: " + vehiculo.getModelo());
	        System.out.println("tipo: " + vehiculo.getTipo());
	        //System.out.println("cedula: " + vehiculo.getPersona());

	        System.out.println("-----------------------------");
	    }
	}
}

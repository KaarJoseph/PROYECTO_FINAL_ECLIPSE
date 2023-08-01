package ups.edu.ec.proyecto.Services;

import java.sql.Connection;
import java.util.List;

import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.GenericEntity;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import ups.edu.ec.proyecto.Datos.PersonaDao;
import ups.edu.ec.proyecto.Modelo.Persona;
import ups.edu.ec.proyecto.Negocio.GestionClientes;

@Path("clientes")
public class GClientesService {
	
	@Inject
	private GestionClientes GClientes;
	
	@Inject
	private PersonaDao daoPersona;
    
	@POST	
	@Produces("application/json")
	@Consumes("application/json")
	public Response guardarCliente(Persona persona) {
		try {
			GClientes.guardarClientes(persona);
			return Response.status(Response.Status.OK).entity(persona).build();
		}catch(Exception e){
			e.printStackTrace();
			Error error = new Error();
			error.setCodigo(99);
			error.setMensaje("Error al guardar: " +e.getMessage());
			return Response.status(Response.Status.OK).entity(error).build();
		}
	}
    
    @GET
    @Path("all")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPersona() {
        List<Persona> listado = 
        		GClientes.getClientes();
        
        return Response.status(Response.Status.OK).entity(listado).build();
    }
    
    
    @GET
    @Path("lista")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Persona> getListadoPersona(){
    	return daoPersona.getAll();
    }
      
    
    @DELETE
	@Path("elim/{cedula}")
	public String eliminar2(@PathParam("cedula") String cedula) {
		try {
			GClientes.eliminarCliente(cedula);
			return"elimina";
		} catch (Exception e) {

			// TODO: handle exception
			Error error = new Error();
			error.setCodigo(99);
			error.setMensaje("error al guardar:" + e.getMessage());
			return "no";
		}
	}
    
 
}

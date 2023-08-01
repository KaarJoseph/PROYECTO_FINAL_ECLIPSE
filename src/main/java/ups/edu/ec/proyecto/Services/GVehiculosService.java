package ups.edu.ec.proyecto.Services;

import java.util.List;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import ups.edu.ec.proyecto.Datos.VehiculoDao;
import ups.edu.ec.proyecto.Modelo.Vehiculo;
import ups.edu.ec.proyecto.Negocio.GestionVehiculos;

@Path("vehiculos")
public class GVehiculosService {

	
	@Inject
	private GestionVehiculos GVehiculos;
	
	@Inject
	private VehiculoDao daoVehiculo;
	
	@POST	
	@Produces("application/json")
	@Consumes("application/json")
	public Response guardarCliente(Vehiculo vehiculo) {
		try {
			GVehiculos.guardarVehiculos(vehiculo);
			return Response.status(Response.Status.OK).entity(vehiculo).build();
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
    public Response getVehiculo() {
        List<Vehiculo> listado = 
        		GVehiculos.getVehiculos();
        
        return Response.status(Response.Status.OK).entity(listado).build();
    }
    
    @GET
    @Path("lista")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Vehiculo> getListadoVehiculos(){
    	
    	return daoVehiculo.getAll();
    	
    }
    
    @GET
	@Path("lista2")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Vehiculo> getListadoVehiculos2() {
		
	return daoVehiculo.getAll();
			
	}
    
    
    @DELETE
	@Path("elim/{placa}")
	public String eliminar2(@PathParam("placa") String placa) {
		try {
			GVehiculos.eliminarVehiculo(placa);
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

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
import ups.edu.ec.proyecto.Modelo.Detalle;
import ups.edu.ec.proyecto.Negocio.GestionDetalles;

@Path("detalles")
public class GDetallesService {

	@Inject
	private GestionDetalles gestionDetalles;
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response guardarDetalle(Detalle detalle) {
		try {
			gestionDetalles.guardarDetalle(detalle);
			return Response.status(Response.Status.OK).entity(detalle).build();
		} catch (Exception e) {
			e.printStackTrace();
			Error error = new Error();
			error.setCodigo(99);
			error.setMensaje("Error al guardar detalle: " + e.getMessage());
			return Response.status(Response.Status.OK).entity(error).build();
		}
	}
	
	@GET
	@Path("all")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getDetalles() {
		List<Detalle> detalles = gestionDetalles.getDetalles();
		return Response.status(Response.Status.OK).entity(detalles).build();
	}
	
	@DELETE
	@Path("{detalleId}")
	public Response eliminarDetalle(@PathParam("detalleId") int detalleId) {
		try {
			gestionDetalles.eliminarDetalle(detalleId);
			return Response.status(Response.Status.OK).entity("Detalle eliminado").build();
		} catch (Exception e) {
			e.printStackTrace();
			Error error = new Error();
			error.setCodigo(99);
			error.setMensaje("Error al eliminar detalle: " + e.getMessage());
			return Response.status(Response.Status.OK).entity(error).build();
		}
	}
}

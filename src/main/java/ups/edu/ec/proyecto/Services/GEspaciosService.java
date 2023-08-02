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
import ups.edu.ec.proyecto.Modelo.Espacio;
import ups.edu.ec.proyecto.Negocio.GestionEspacios;

@Path("espacios")
public class GEspaciosService {

    @Inject
    private GestionEspacios gestionEspacios;

    @POST	
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response guardarEspacio(Espacio espacio) {
        try {
            gestionEspacios.guardarEspacio(espacio);
            return Response.status(Response.Status.OK).entity(espacio).build();
        } catch (Exception e) {
            e.printStackTrace();
            Error error = new Error();
            error.setCodigo(99);
            error.setMensaje("Error al guardar: " + e.getMessage());
            return Response.status(Response.Status.OK).entity(error).build();
        }
    }

    @GET
    @Path("all")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getEspacios() {
        List<Espacio> espacios = gestionEspacios.getEspacios();
        return Response.status(Response.Status.OK).entity(espacios).build();
    }

    @DELETE
    @Path("elim/{espacioId}")
    public Response eliminarEspacio(@PathParam("espacioId") int espacioId) {
        gestionEspacios.eliminarEspacio(espacioId);
        return Response.status(Response.Status.OK).build();
    }

}

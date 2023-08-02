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
import ups.edu.ec.proyecto.Modelo.Cabecera;
import ups.edu.ec.proyecto.Negocio.GestionCabeceras;

@Path("cabeceras")
public class GCabecerasService {

    @Inject
    private GestionCabeceras gestionCabeceras;

    @POST	
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response guardarCabecera(Cabecera cabecera) {
        try {
            gestionCabeceras.guardarCabecera(cabecera);
            return Response.status(Response.Status.OK).entity(cabecera).build();
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
    public Response getCabeceras() {
        List<Cabecera> cabeceras = gestionCabeceras.getCabeceras();
        return Response.status(Response.Status.OK).entity(cabeceras).build();
    }

    @DELETE
    @Path("elim/{cabeceraId}")
    public Response eliminarCabecera(@PathParam("cabeceraId") int cabeceraId) {
        gestionCabeceras.eliminarCabecera(cabeceraId);
        return Response.status(Response.Status.OK).build();
    }

}

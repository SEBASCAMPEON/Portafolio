package co.adsicbi.portafolio.rest.services;

import co.adsicbi.portafolio.jpa.entities.CalificacionesServicio;
import co.adsicbi.portafolio.jpa.sessions.CalificacionesServicioFacade;
import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author leoandresm
 */
@Path("calificacionesServicio")
public class CalificacionServiciosRest {

    @EJB
    private CalificacionesServicioFacade ejbCalificacionesServiciosFacade;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void create(CalificacionesServicio calificacionesServicio) {
        ejbCalificacionesServiciosFacade.create(calificacionesServicio);
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void edit(@PathParam("id") String id, CalificacionesServicio calificacionesServicio) {
        ejbCalificacionesServiciosFacade.edit(calificacionesServicio);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") String id) {
        ejbCalificacionesServiciosFacade.remove(ejbCalificacionesServiciosFacade.find(id));
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<CalificacionesServicio> findAll() {
        return ejbCalificacionesServiciosFacade.findAll();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public CalificacionesServicio findById(@PathParam("id") String id) {
        return ejbCalificacionesServiciosFacade.find(id);
    }
}

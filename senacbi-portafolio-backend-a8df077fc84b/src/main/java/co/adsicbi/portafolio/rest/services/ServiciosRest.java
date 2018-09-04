package co.adsicbi.portafolio.rest.services;

import co.adsicbi.portafolio.jpa.entities.Servicios;
import co.adsicbi.portafolio.jpa.sessions.ServiciosFacade;
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
@Path("servicios")
public class ServiciosRest {

    @EJB
    private ServiciosFacade ejbServiciosFacade;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void create(Servicios servicios) {
        ejbServiciosFacade.create(servicios);
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void edit(@PathParam("id") String id, Servicios servicios) {
        ejbServiciosFacade.edit(servicios);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") String id) {
        ejbServiciosFacade.remove(ejbServiciosFacade.find(id));
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Servicios> findAll() {
        return ejbServiciosFacade.findAll();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Servicios findById(@PathParam("id") String id) {
        return ejbServiciosFacade.find(id);
    }
}

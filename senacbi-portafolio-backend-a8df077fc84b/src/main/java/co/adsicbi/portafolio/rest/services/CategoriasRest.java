package co.adsicbi.portafolio.rest.services;

import co.adsicbi.portafolio.jpa.entities.Categorias;
import co.adsicbi.portafolio.jpa.sessions.CategoriasFacade;
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
@Path("categorias")
public class CategoriasRest {

    @EJB
    private CategoriasFacade ejbCategoriasFacade;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void create(Categorias categoria) {
        ejbCategoriasFacade.create(categoria);
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void edit(@PathParam("id") String id, Categorias categoria) {
        ejbCategoriasFacade.edit(categoria);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") String id) {
        ejbCategoriasFacade.remove(ejbCategoriasFacade.find(id));
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Categorias> findAll() {
        return ejbCategoriasFacade.findAll();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Categorias findById(@PathParam("id") String id) {
        return ejbCategoriasFacade.find(id);
    }
}

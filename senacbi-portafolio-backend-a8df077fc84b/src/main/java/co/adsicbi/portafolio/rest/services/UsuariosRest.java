package co.adsicbi.portafolio.rest.services;

import co.adsicbi.portafolio.jpa.entities.Usuarios;
import co.adsicbi.portafolio.jpa.sessions.UsuariosFacade;
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
@Path("usuarios")
public class UsuariosRest {

    @EJB
    private UsuariosFacade ejbUsuariosFacade;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void create(Usuarios usuario) {
        ejbUsuariosFacade.create(usuario);
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void edit(@PathParam("id") Integer id, Usuarios usuario) {
        ejbUsuariosFacade.edit(usuario);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        ejbUsuariosFacade.remove(ejbUsuariosFacade.find(id));
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Usuarios> findAll() {
        return ejbUsuariosFacade.findAll();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Usuarios findById(@PathParam("id") Integer id) {
        return ejbUsuariosFacade.find(id);
    }
    
    @GET
    @Path("nombre/{nombre}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Usuarios> findByNombre(@PathParam("nombre") String nombre){
        return ejbUsuariosFacade.findByNombre(nombre);
    }

}

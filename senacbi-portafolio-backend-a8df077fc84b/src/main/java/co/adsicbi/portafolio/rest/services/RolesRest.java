package co.adsicbi.portafolio.rest.services;

import co.adsicbi.portafolio.jpa.entities.Roles;
import co.adsicbi.portafolio.jpa.sessions.RolesFacade;
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
@Path("roles")
public class RolesRest {

    @EJB
    private RolesFacade ejbRolesFacade;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void create(Roles rol) {
        ejbRolesFacade.create(rol);
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void edit(@PathParam("id") String id, Roles rol) {
        ejbRolesFacade.edit(rol);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") String id) {
        ejbRolesFacade.remove(ejbRolesFacade.find(id));
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Roles> findAll() {
        return ejbRolesFacade.findAll();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Roles findById(@PathParam("id") String id) {
        return ejbRolesFacade.find(id);
    }
}

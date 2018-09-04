package co.adsicbi.portafolio.jpa.sessions;

import co.adsicbi.portafolio.jpa.entities.Usuarios;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;

/**
 *
 * @author leoandresm
 */
@Stateless
public class UsuariosFacade extends AbstractFacade<Usuarios> {
    @PersistenceContext(unitName = "co.adsicbi.portafolio_Portafolio-Backend_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuariosFacade() {
        super(Usuarios.class);
    }
    
    public Usuarios findByEmail(String email) {
        try {
            return (Usuarios) getEntityManager().createNamedQuery("Usuarios.findByEmail")
                    .setParameter("email", email)
                    .getSingleResult();
        } catch (NonUniqueResultException ex) {
            throw ex;
        } catch (NoResultException ex) {
            return null;
        }
    }
    
    public List<Usuarios> findByNombre(String nombre) {
        return getEntityManager().createNamedQuery("Usuarios.findByNombres")
                .setParameter("nombres", nombre + "%")
                .getResultList();
    }
    
}

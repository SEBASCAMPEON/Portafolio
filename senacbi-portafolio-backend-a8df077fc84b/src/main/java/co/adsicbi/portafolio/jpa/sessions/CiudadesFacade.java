/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.adsicbi.portafolio.jpa.sessions;

import co.adsicbi.portafolio.jpa.entities.Ciudades;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author leoandresm
 */
@Stateless
public class CiudadesFacade extends AbstractFacade<Ciudades> {

    @PersistenceContext(unitName = "co.adsicbi.portafolio_Portafolio-Backend_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CiudadesFacade() {
        super(Ciudades.class);
    }

    public List<Ciudades> findByNombre(String nombre) {
        return getEntityManager().createNamedQuery("Ciudades.findByNombreCiudad")
                .setParameter("nombreCiudad", nombre + "%")
                .getResultList();
    }

}

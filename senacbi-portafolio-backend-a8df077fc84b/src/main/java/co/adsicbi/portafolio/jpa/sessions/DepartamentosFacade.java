/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.adsicbi.portafolio.jpa.sessions;

import co.adsicbi.portafolio.jpa.entities.Departamentos;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author leoandresm
 */
@Stateless
public class DepartamentosFacade extends AbstractFacade<Departamentos> {
    @PersistenceContext(unitName = "co.adsicbi.portafolio_Portafolio-Backend_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DepartamentosFacade() {
        super(Departamentos.class);
    }
    
}

package com.meajudaserver.dao;

import com.meajudaserver.model.Chamado;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class ChamadoDAO extends AbstractFacade<Chamado>{

    @PersistenceContext
    private EntityManager em;
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    public ChamadoDAO()
    {
        super(Chamado.class);
    }
    
}

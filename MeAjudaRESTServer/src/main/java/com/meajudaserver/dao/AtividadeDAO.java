/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.meajudaserver.dao;

import com.meajudaserver.model.Atividade;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author joao
 */
@Stateless
public class AtividadeDAO extends AbstractFacade<Atividade> {
    
    @PersistenceContext
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AtividadeDAO() {
        super(Atividade.class);
    }

}

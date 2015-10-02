/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.meajudaserver.dao;

import com.meajudaserver.model.Cliente;
import com.meajudaserver.model.Usuario;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author joao
 */
@Stateless
public class ClienteDAO extends AbstractFacade<Cliente> {
    
    @PersistenceContext
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ClienteDAO() {
        super(Cliente.class);
    }

}

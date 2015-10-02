/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.meajuda.service;

import com.meajuda.model.Usuario;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

@Stateless
public class UsuarioService implements Serializable{
    
    private final Client rsClient = ClientBuilder.newClient();      
    
    public Usuario get(Integer id) {
        WebTarget target = rsClient.target(Configuracoes.URI_USUARIO);
        Response r;
        try {
            GenericType<Usuario> type = new GenericType<Usuario>() {};
            r = target.path("{id}").resolveTemplate("id", id).request().get();
            return r.readEntity(type);
        } catch (Exception e1) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, e1);
        }
        return null;
    }
}

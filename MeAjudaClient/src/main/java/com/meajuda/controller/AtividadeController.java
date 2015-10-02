/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.meajuda.controller;

import com.meajuda.model.RetornoErro;
import com.meajuda.model.Atividade;
import com.meajuda.service.Configuracoes;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author joao
 */
@Named
@ViewScoped
public class AtividadeController extends AbstractController<Atividade>{ 
  
    @Override
    public List<Atividade> getList()  {
            Response r = null;
            Client rsClient = ClientBuilder.newClient();
            try {
                WebTarget target = rsClient.target(getUri());
                Response response = target.request(MediaType.APPLICATION_JSON).get();
                if (response.getStatus() == 200) {
                    GenericType<List<Atividade>> listType = new GenericType<List<Atividade>>() {};
                    list = response.readEntity(listType);
                    return list;
                } else {
                    GenericType<RetornoErro> retorno = new GenericType<RetornoErro>() {};
                    RetornoErro retornoErro = response.readEntity(retorno);
                    throw new Exception(retornoErro.toString());
                }
            } catch (Exception e1) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, e1);
                JsfUtil.addMessage(e1.getMessage(), FacesMessage.SEVERITY_ERROR);
            } finally {
                if (r != null) {
                    r.close();
                }
                rsClient.close();
            }           
        return null;
    }

    @Override
    protected String getUri() {
        return Configuracoes.URI_ATIVIDADE;
    }
    
    

}

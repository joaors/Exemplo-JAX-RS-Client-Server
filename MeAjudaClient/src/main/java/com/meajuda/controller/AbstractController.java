/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.meajuda.controller;

import com.meajuda.model.BaseModel;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author joao
 * @param <T>
 */
public abstract class AbstractController<T extends BaseModel> implements Serializable {

    private T selected;
    
    protected abstract String getUri();
    
    private Response r;
    
    private final Client rsClient = ClientBuilder.newClient();
    
    protected List<T> list;
    
    public AbstractController() {}
    
    public abstract List<T> getList();

    public T getSelected() {
        return selected;
    }
    
    public void setList(List<T> lista) {
        this.list = lista;
    }    

    public void setSelected(T selected) {
        this.selected = selected;
    }

    public void salvar() {
        Objects.requireNonNull(getUri(), "Uri não configurado");
        WebTarget target = rsClient.target(getUri());
        try {
            if (selected.getId() == null) {
                r = target.request()		
                        .header("Content-Type", MediaType.APPLICATION_JSON)
                        .post(Entity.json(getSelected()));
            } else {
                r = target.request()		
                        .header("Content-Type", MediaType.APPLICATION_JSON)
                        .put(Entity.json(getSelected()));                
            }
            JsfUtil.addMessage("Salvo com Sucesso", FacesMessage.SEVERITY_INFO);            
        } catch (Exception ex) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
            JsfUtil.addMessage(ex.getMessage(), FacesMessage.SEVERITY_ERROR);
        }
    }
    

    public void delete(T entity) {
        WebTarget target = rsClient.target(getUri());
        try {
            target.path("{id}").resolveTemplate("id", entity.getId()).request().delete();
            JsfUtil.addMessage("Excluido com Sucesso", FacesMessage.SEVERITY_INFO);            
        } catch (Exception e1) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, e1);
            JsfUtil.addMessage(e1.getMessage(), FacesMessage.SEVERITY_ERROR);
        }
    }
    
    public void voltar() {
        selected = null;
    }    

    public void prepareCreate() {
        T newItem;
        try {
            newItem = getEntityBeanType().newInstance();
            selected = (T) newItem;
        } catch (IllegalAccessException | InstantiationException  ex) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);            
        }
    }
    
    @SuppressWarnings("unchecked")
    private Class<T> getEntityBeanType() {
        return (Class<T>) ((ParameterizedType)(super.getClass().getGenericSuperclass())).getActualTypeArguments()[0];
    }          
         
}

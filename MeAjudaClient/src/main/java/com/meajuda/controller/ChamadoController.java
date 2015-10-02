package com.meajuda.controller;

import com.meajuda.model.Artefato;
import com.meajuda.model.Atendimento;
import com.meajuda.model.Chamado;
import com.meajuda.model.Cliente;
import com.meajuda.model.RetornoErro;
import com.meajuda.model.Usuario;
import com.meajuda.service.Configuracoes;
import java.util.ArrayList;
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
import org.primefaces.context.RequestContext;

@Named
@ViewScoped
public class ChamadoController extends AbstractController<Chamado>{
    
    private Atendimento atendimento;
    
    private List<Usuario> usuarios;
    
    private List<Cliente> clientes;
    
    private List<Artefato> artefatos;    
        
    @Override
    public List<Chamado> getList()  {
        if(list == null) {
            Response r = null;
            Client rsClient = ClientBuilder.newClient();
            try {
                WebTarget target = rsClient.target(getUri());
                Response response = target.request(MediaType.APPLICATION_JSON).get();
                if (response.getStatus() == 200) {
                    GenericType<List<Chamado>> listType = new GenericType<List<Chamado>>() {};
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
        }
        return list;
    }
    
    public void prepareAtendimento() {
        this.atendimento = new Atendimento(getSelected());
        RequestContext.getCurrentInstance().execute("PF('dlg').show();");
    }
    
    public void closeDialog() {
        RequestContext.getCurrentInstance().execute("PF('dlg').hide();");
    }    
        
    public void adicionaAtendimento() {
        getSelected().addAtendimento(this.atendimento);
        closeDialog();
        this.atendimento = null;
    }
    
    public List<Usuario> getUsuarios() {
        if (usuarios == null) {
                Response r = null;
                Client rsClient = ClientBuilder.newClient();
                try {
                    WebTarget target = rsClient.target(Configuracoes.URI_USUARIO);
                    Response response = target.request(MediaType.APPLICATION_JSON).get();
                    if (response.getStatus() == 200) {
                        GenericType<List<Usuario>> listType = new GenericType<List<Usuario>>() {};
                        return response.readEntity(listType);
                    } 
                } catch (Exception e1) {
                    JsfUtil.addMessage(e1.getMessage(), FacesMessage.SEVERITY_ERROR);
                } finally {
                    if (r != null) {
                        r.close();
                    }
                    rsClient.close();
                }
        }
        return new ArrayList<>();
    }
    
    public List<Artefato> getArtefatos() {
        if (artefatos == null) {
                Response r = null;
                Client rsClient = ClientBuilder.newClient();
                try {
                    WebTarget target = rsClient.target(Configuracoes.URI_ARTEFATO);
                    Response response = target.request(MediaType.APPLICATION_JSON).get();
                    if (response.getStatus() == 200) {
                        GenericType<List<Artefato>> listType = new GenericType<List<Artefato>>() {};
                        return response.readEntity(listType);
                    } 
                } catch (Exception e1) {
                    JsfUtil.addMessage(e1.getMessage(), FacesMessage.SEVERITY_ERROR);
                } finally {
                    if (r != null) {
                        r.close();
                    }
                    rsClient.close();
                }
        }
        return new ArrayList<>();
    }
    
    public List<Cliente> getClientes() {
        if (clientes == null) {
                Response r = null;
                Client rsClient = ClientBuilder.newClient();
                try {
                    WebTarget target = rsClient.target(Configuracoes.URI_CLIENTE);
                    Response response = target.request(MediaType.APPLICATION_JSON).get();
                    if (response.getStatus() == 200) {
                        GenericType<List<Cliente>> listType = new GenericType<List<Cliente>>() {};
                        return response.readEntity(listType);
                    } 
                } catch (Exception e1) {
                    JsfUtil.addMessage(e1.getMessage(), FacesMessage.SEVERITY_ERROR);
                } finally {
                    if (r != null) {
                        r.close();
                    }
                    rsClient.close();
                }
        }
        return new ArrayList<>();
    }
    
    public void setAtendimento(Atendimento atendimento) {
        this.atendimento = atendimento;
    }
    
    public Atendimento getAtendimento() {
        return this.atendimento;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }    
    
    @Override
    protected String getUri() {
        return Configuracoes.URI_CHAMADO;
    }    
    
}

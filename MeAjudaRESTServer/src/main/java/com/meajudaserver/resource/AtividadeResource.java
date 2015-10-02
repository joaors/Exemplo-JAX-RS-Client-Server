/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.meajudaserver.resource;

import com.meajudaserver.model.Atividade;
import com.meajudaserver.dao.AtividadeDAO;
import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.Response;

/**
 *
 * @author joao
 */

@Path("atividade")
public class AtividadeResource {
    
    @Inject
    private AtividadeDAO dao;
    
    @GET
    @Path("{id}")
    @Produces({"application/json"})
    public Response buscar(@PathParam("id") Integer id) {
        Atividade atividade = dao.find(id);
        return Response
            .status(Response.Status.OK)
            .entity(atividade)
            .build();
    }

    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public Response criar(Atividade atividade) {
        dao.persist(atividade);
       return Response
               .status(Response.Status.CREATED)
               .entity(atividade)
               .build(); 
    }
    
    @PUT
    @Consumes("application/json")
    @Produces("application/json")
    public Response salvar(Atividade atividade) {
        dao.edit(atividade);
       return Response
               .status(Response.Status.OK)
               .entity(atividade)
               .build(); 
    }    

    @DELETE
    @Path("{id}")
    public Response remover(@PathParam("id") Integer id) {        
        dao.remove(id);
       return Response
               .status(Response.Status.OK)
               .build();         
    }

    @GET
    @Produces({"application/json"})
    public Response buscarTodos() {    
        List<Atividade> atividades = dao.findAll();
        GenericEntity<List<Atividade>> usuarioWrapper = new GenericEntity<List<Atividade>>(atividades) {};
        return Response
                .status(Response.Status.OK)
                .entity(usuarioWrapper)
                .build();
    }
    
    
}

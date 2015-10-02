/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.meajudaserver.resource;

import com.meajudaserver.model.Artefato;
import com.meajudaserver.dao.ArtefatoDAO;
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

@Path("artefato")
public class ArtefatoResource {
    
    @Inject
    private ArtefatoDAO dao;
    
    @GET
    @Path("{id}")
    @Produces({"application/json"})
    public Response buscar(@PathParam("id") Integer id) {
        Artefato artefato = dao.find(id);
        return Response
            .status(Response.Status.OK)
            .entity(artefato)
            .build();
    }

    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public Response criar(Artefato artefato) {
        dao.persist(artefato);
       return Response
               .status(Response.Status.CREATED)
               .entity(artefato)
               .build(); 
    }
    
    @PUT
    @Consumes("application/json")
    @Produces("application/json")
    public Response salvar(Artefato artefato) {
        dao.edit(artefato);
       return Response
               .status(Response.Status.OK)
               .entity(artefato)
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
        List<Artefato> artefatos = dao.findAll();
        GenericEntity<List<Artefato>> artefatoWrapper = new GenericEntity<List<Artefato>>(artefatos) {};
        return Response
                .status(Response.Status.OK)
                .entity(artefatoWrapper)
                .build();
    }
    
    
}

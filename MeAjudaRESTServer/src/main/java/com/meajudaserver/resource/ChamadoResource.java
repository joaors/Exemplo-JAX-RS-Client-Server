/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.meajudaserver.resource;


import com.meajudaserver.model.Chamado;
import com.meajudaserver.dao.ChamadoDAO;
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

@Path("chamado")
public class ChamadoResource {
    
    @Inject
    private ChamadoDAO dao;
    
    @GET
    @Path("{id}")
    @Produces({"application/json"})
    public Response buscar(@PathParam("id") Integer id){
        
        Chamado chamado = dao.find(id);
        return Response
            .status(Response.Status.OK)
            .entity(chamado)
            .build();
    }
    
    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public Response criar(Chamado chamado) {
        dao.persist(chamado);
        return Response
               .status(Response.Status.CREATED)
               .entity(chamado)
               .build(); 
    }
    
    @PUT
    @Consumes("application/json")
    @Produces("application/json")
    public Response salvar(Chamado chamado) {
        dao.edit(chamado);
       return Response
               .status(Response.Status.OK)
               .entity(chamado)
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
        List<Chamado> chamados = dao.findAll();
        GenericEntity<List<Chamado>> usuarioWrapper = new GenericEntity<List<Chamado>>(chamados) {};
        return Response
                .status(Response.Status.OK)
                .entity(usuarioWrapper)
                .build();
    }
    
}

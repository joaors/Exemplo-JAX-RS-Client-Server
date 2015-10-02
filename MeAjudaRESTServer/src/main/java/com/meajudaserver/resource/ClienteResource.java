/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.meajudaserver.resource;

import com.meajudaserver.model.Cliente;
import com.meajudaserver.dao.ClienteDAO;
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
@Path("cliente")
public class ClienteResource {
    
    @Inject
    private ClienteDAO dao;
    
    
    @GET
    @Path("{id}")
    @Produces({"application/json"})
    public Response buscar(@PathParam("id") Integer id) {
        Cliente cliente = dao.find(id);
        return Response
            .status(Response.Status.OK)
            .entity(cliente)
            .build();
    }

    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public Response criar(Cliente cliente) {
        dao.persist(cliente);
       return Response
               .status(Response.Status.CREATED)
               .entity(cliente)
               .build(); 
    }
    
    @PUT
    @Consumes("application/json")
    @Produces("application/json")
    public Response salvar(Cliente cliente) {
        dao.edit(cliente);
       return Response
               .status(Response.Status.OK)
               .entity(cliente)
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
        List<Cliente> clientes = dao.findAll();
        GenericEntity<List<Cliente>> clienteWrapper = new GenericEntity<List<Cliente>>(clientes) {};
        return Response
                .status(Response.Status.OK)
                .entity(clienteWrapper)
                .build();
    }
    
}

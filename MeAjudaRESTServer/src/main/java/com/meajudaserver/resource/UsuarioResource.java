/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.meajudaserver.resource;

import com.meajudaserver.model.Usuario;
import com.meajudaserver.dao.UsuarioDAO;
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
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author joao
 */
@Path("usuario")
public class UsuarioResource {
    
    @Inject
    private UsuarioDAO dao;
    
    
    @GET
    @Path("{id}")
    @Produces({"application/json"})
    public Usuario buscar(@PathParam("id") Integer id) {
        Usuario usuario = dao.find(id);
        return usuario;
    }

    @POST
    @Consumes("application/json")
    @Produces(MediaType.APPLICATION_JSON)
    public Response criar(Usuario usuario) {
        dao.persist(usuario);
       return Response
               .status(Response.Status.CREATED)
               .entity(usuario)
               .build(); 
    }
    
    @PUT
    @Consumes("application/json")
    @Produces(MediaType.APPLICATION_JSON)
    public Response salvar(Usuario usuario) {
        dao.edit(usuario);
       return Response
               .status(Response.Status.OK)
               .entity(usuario)
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
    @Produces(MediaType.APPLICATION_JSON)
    public List<Usuario> buscarTodos() {    
        List<Usuario> usuarios = dao.findAll();    
        return usuarios;
    }
    
}

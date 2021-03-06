/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agenda.service;

import agenda.Hijo;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author auxi
 */
@Stateless
@Path("hijo")
public class HijoFacadeREST extends AbstractFacade<Hijo> {

    @PersistenceContext(unitName = "WebApplication1PU")
    private EntityManager em;

    public HijoFacadeREST() {
        super(Hijo.class);
    }

    /**
     *
     * @param entity
     */
    @POST
    @Override
    @Consumes({MediaType.APPLICATION_JSON})
    public void create(Hijo entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, Hijo entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public Hijo find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_JSON})
    public List<Hijo> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_JSON})
    public List<Hijo> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        em = Persistence.createEntityManagerFactory("WebApplication1PU").createEntityManager();
        return em;
    }
    
    @GET
    @Path("hijos/{idpadre}")
    @Produces({MediaType.APPLICATION_JSON})
    public String obtenerHijos(@PathParam("idpadre") Integer idpadre){
        return super.obtenerHijos(idpadre);
    }
    
    
    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    @Path("obtenerHijosPost")
    @Produces({MediaType.APPLICATION_JSON})
    public String findMail(String padre) throws IOException, ParseException, org.json.simple.parser.ParseException {
        return super.obtenerHijosPost(padre);
    }
}

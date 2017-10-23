/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agenda.service;

import agenda.Usuario;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
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
import javax.ws.rs.core.Response.Status;

/**
 *
 * @author CF
 */
@Stateless
@Path("usuario")
public class UsuarioFacadeREST extends AbstractFacade<Usuario> {

    @PersistenceContext(unitName = "WebApplication1PU")
    private EntityManager em;

    public UsuarioFacadeREST() {
        super(Usuario.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_JSON})
    public void create(Usuario entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, Usuario entity) {
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
    public Usuario find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_JSON})
    public List<Usuario> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_JSON})
    public List<Usuario> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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
    
    /*@POST
    @Consumes({MediaType.APPLICATION_JSON})
    @Path("validarUsuario")
    @Produces({MediaType.APPLICATION_JSON})
    public String findMail(String email) throws IOException, ParseException, org.json.simple.parser.ParseException {
        return super.validarUsuario(email);
    }*/
    
    @POST
    @Path("validarUsuario")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN})
    @Produces({MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN})
    public Response findMail(String email) throws IOException, ParseException, org.json.simple.parser.ParseException {
        
        if (email == null){
            return Response.status(Status.NOT_FOUND).header("Access-Control-Allow-Origin", "*").build();
        }
        Query q = getEntityManager().createNativeQuery("SELECT u.id FROM Usuario u WHERE u.correo = ?");
        q.setParameter(1, email);
        try{
            Object res = q.getSingleResult();
            return Response.ok(res.toString()).header("Access-Control-Allow-Origin", "*").build();
        }
        catch (Exception e){
            return Response.status(Status.NOT_FOUND).header("Access-Control-Allow-Origin", "*").build();
        }
        
    //return super.validarUsuario(intento);
        //JSONObject obj = new JSONObject();
        //JSONParser parser = new JSONParser();
        //JSONObject json = (JSONObject) parser.parse(email);

        //JSONObject jsonObject = (JSONObject) json;
        //String emailConsulta = (String) jsonObject.get("email");
        
        //String emailConsulta = intento.getEmail();
        /*
        boolean valido = true;
        Object resultado;
        try{
            resultado = getEntityManager().createNamedQuery("Usuario.findByCorreo").setParameter("correo",email)
                    .getSingleResult();
        }catch(Exception e){
            return "No existe el usuario";
        }
        String id = "";
        String nombre = "";
        
        if (resultado == null) {
            valido = false;
        } else {
            id = ((Usuario)resultado).getId().toString();
            nombre = ((Usuario)resultado).getNombre();
        }
        
       
//        String nombre = getEntityManager().createNativeQuery("SELECT nombre FROM Usuario u WHERE u.correo = '" + emailConsulta + "'")
//                .getResultList().toString();
//        
//        String id = getEntityManager().createNativeQuery("SELECT id FROM Usuario u WHERE u.correo = '" + emailConsulta + "'")
//                .getResultList().toString();
       

               
        if (!valido) {

            obj.put("valido", false);
        } else {
            String nombreParaObjeto = nombre;
        
            String idParaObjeto = id;
            obj.put("valido", true);
            obj.put("email", email);
            obj.put("nombre", nombreParaObjeto);
            obj.put("idUsuario", idParaObjeto);
        }

        StringWriter out = new StringWriter();
        obj.writeJSONString(out);

        String jsonText = out.toString();
        return jsonText;*/
    }  
}

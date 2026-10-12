package webservices;
import entities.UniteEnseignement;
import metiers.UniteEnseignementBusiness;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/ue")
public class UniteEnsRestApi {

    public  static UniteEnseignementBusiness helper =new UniteEnseignementBusiness();

    @Path("/list")
    @Produces(MediaType.APPLICATION_JSON)
    @GET
    public Response GetList(){
        return Response.ok().entity(helper.getListeUE()).build();
    }

    @Path("/new")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)

    public Response createUE(UniteEnseignement unit){
        if (helper.addUniteEnseignement(unit)){
            return Response.ok(201).entity("ok").build();
        }
        return Response.status(Response.Status.BAD_REQUEST).build();
    }
    @Path("/{code}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getueByCode(@PathParam("code") int code){
        return Response.ok(helper.getUEByCode(code)).build();
    }

    //http://localhost:8080/Gestion_UE_VF_war_exploded/api/ue/?sem=1
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getueBySem(@QueryParam("sem") int sem){
        return Response.ok(helper.getUEBySemestre(sem)).build();
    }



}

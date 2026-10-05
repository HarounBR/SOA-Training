package webservices;
import metiers.UniteEnseignementBusiness;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/ue")
public class UniteEnsRestApi {

    public  UniteEnseignementBusiness helper =new UniteEnseignementBusiness();

    @Path("/list")
    @Produces(MediaType.APPLICATION_JSON)
    @GET
    public Response GetList(){
        return Response.ok().entity(helper.getListeUE()).build();
    }
}

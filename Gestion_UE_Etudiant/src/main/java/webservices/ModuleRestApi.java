package webservices;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import metiers.ModuleBusiness;
import entities.Module;
 @Path("/modul")
public class ModuleRestApi {
    public static ModuleBusiness modul =new ModuleBusiness() ;

    @Path("/list")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response listModule() {
        return Response.ok().entity(modul.getAllModules()).build();
    }


 }

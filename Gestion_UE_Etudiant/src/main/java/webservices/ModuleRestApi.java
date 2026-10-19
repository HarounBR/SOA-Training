package webservices;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import metiers.ModuleBusiness;
import entities.Module;

import java.util.List;

@Path("/modul")
public class ModuleRestApi {
    public static ModuleBusiness modul =new ModuleBusiness();

    @Path("/list")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response listModule() {
        return Response.ok().entity(modul.getAllModules()).build();
    }
    @Path("/add")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
     public  Response adddModule(Module module) {
        if(modul.addModule(module)){
            return Response.ok(201).entity("ok").build();
        }
        return Response.status(Response.Status.BAD_REQUEST).build();
    }

     @Path("/{matri}")
     @GET
     @Produces(MediaType.APPLICATION_JSON)
     public Response getModulByMatri(@PathParam("matri") String matricule){
         return Response.ok(modul.getModuleByMatricule(matricule)).build();
     }

     @Path("/type")
     @GET
     @Produces(MediaType.APPLICATION_JSON)
     public Response getModulByType(@QueryParam("type") Module.TypeModule type){
         List<Module> result = modul.getModulesByType(type);

         System.out.println("Type reçu : " + type);
         System.out.println("Nombre de modules : " + result.size());

         return Response.ok(result).build();
     }

     @Path("/{matricule}")
     @POST
     @Consumes(MediaType.APPLICATION_JSON)
     public Response updateModule(@PathParam("matricule") String matricule, Module updatedModule) {
        if (modul.updateModule(matricule, updatedModule)) {
            return Response.ok(201).entity("ok").build();
        }
        return Response.status(Response.Status.BAD_REQUEST).build();
     }
     @Path("/{matricule}")
     @DELETE
     public Response deleteModulee(@PathParam("matricule") String matricule) {

        if (modul.deleteModule(matricule)) {

            return Response.ok(201).entity("ok").build();
        }
        return Response.status(Response.Status.BAD_REQUEST).build();
     }

 }

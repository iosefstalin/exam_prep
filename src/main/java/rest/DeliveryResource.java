package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dtomappers.DeliveryDTO;
import dtomappers.TruckDTO;
import facades.DeliveryFacade;
import java.util.Date;
import java.util.List;
import javax.annotation.security.RolesAllowed;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.SecurityContext;
import utils.EMF_Creator;

/**
 * @author lamseben
 */
@Path("deliveries")
public class DeliveryResource {

    private static EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory(EMF_Creator.DbSelector.DEV, EMF_Creator.Strategy.CREATE);
        private static final DeliveryFacade FACADE =  DeliveryFacade.getDeliveryFacade(EMF);
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    @Context
    private UriInfo context;

    @Context
    SecurityContext securityContext;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getInfoForAll() {
        System.out.println("Getting to main api page");
        return "{\"msg\":\"Hello anonymous\"}";
    }

    
    @Path("search/{truckId}")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String getTrucksBySearch(@PathParam("truckId") long truckId) {

        
        List<TruckDTO> truckResults = FACADE.getTrucksBySearch(truckId);
        String json = GSON.toJson(truckResults);
        
        return json;
    }
   
    /*@Path("search")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public String flightSearch(String searchInput) {
        TruckDTO t = GSON.fromJson(searchInput, TruckDTO.class);
        Long truckId = t.getTruckId();
        
        System.out.println(truckId);
        System.out.println(t);
        
        List<TruckDTO> truckResults = FACADE.getTrucksBySearch(truckId);
  
        String json = GSON.toJson(truckResults);

        return json;
    }*/
    
    @Path("all")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
     public String allPersons(){
        System.out.println("Getting to /all page");
       
       List<DeliveryDTO> personResults = FACADE.getAllDeliveries();
       String json = GSON.toJson(personResults);

       return json;
   }
}

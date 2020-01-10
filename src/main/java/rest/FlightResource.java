package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dtomappers.FlightDTO;
import static entities.Flight_.departureDate;
import facades.FlightFacade;
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
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.SecurityContext;
import utils.EMF_Creator;

/**
 * @author lamseben
 */
@Path("flights")
public class FlightResource {

    private static EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory(EMF_Creator.DbSelector.DEV, EMF_Creator.Strategy.CREATE);
        private static final FlightFacade FACADE =  FlightFacade.getFlightFacade(EMF);
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    @Context
    private UriInfo context;

    @Context
    SecurityContext securityContext;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getInfoForAll() {
        return "{\"msg\":\"Hello anonymous\"}";
    }

    //Just to verify if the database is setup  

    @Path("search")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public String flightSearch(String searchInput) {
        FlightDTO f = GSON.fromJson(searchInput, FlightDTO.class);
        String departureAirport = f.getDepartureAirportName();
        String arrivalAirport = f.getArrivalAirportName();
        Date departureDate = f.getDepartureDate();
        
        System.out.println(departureDate);
        System.out.println(f);
        
        List<FlightDTO> flightResults = FACADE.getFlightBySearch(departureAirport, arrivalAirport, departureDate);
  
        String json = GSON.toJson(flightResults);

        return json;
    }
    
    @Path("all")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
   public String allFlights(){
       
       List<FlightDTO> flightResults = FACADE.getAllFlights();
       String json = GSON.toJson(flightResults);

       return json;
   }
}

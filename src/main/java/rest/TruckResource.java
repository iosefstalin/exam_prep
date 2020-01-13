/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dtomappers.TruckDTO;
import facades.DeliveryFacade;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.core.UriInfo;
import utils.EMF_Creator;
/**
 *
 * @author jelle
 */


@Path("trucks")
public class TruckResource {

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
    
    @Path("all")
    @GET
     @Produces(MediaType.APPLICATION_JSON)
    public String allTrucks(){
        System.out.println("Getting to /all page");
       
       List<TruckDTO> truckResults = FACADE.getAllTrucks();
       String json = GSON.toJson(truckResults);

       return json;
   }
    
    @Path("search/{truckId}")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String getTrucksBySearch(@PathParam("truckId") long truckId) {

        
        List<TruckDTO> truckResults = FACADE.getTrucksBySearch(truckId);
        String json = GSON.toJson(truckResults);
        
        return json;
    }
}



package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import utils.EMF_Creator;
import facades.StarwarsFacade;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.annotation.security.RolesAllowed;
import javax.persistence.EntityManagerFactory;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("starwars")
public class StarwarsResource {

    private static final EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory(
                "pu",
                "jdbc:mysql://localhost:3307/startcode",
                "dev",
                "ax2",
                EMF_Creator.Strategy.CREATE);
    private static final StarwarsFacade FACADE =  StarwarsFacade.getFacadeExample(EMF);
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    private static final JsonParser jsonParser = new JsonParser();
            
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String getStarwars() throws IOException, MalformedURLException, Exception {
             
        List<String> objects = FACADE.getAllStarwars();
        String newObjects = new Gson().toJson(objects);
        newObjects = newObjects.toString();
        JsonElement jsonElement = jsonParser.parse(newObjects);
        String prettyJson = GSON.toJson(jsonElement);
        

    return prettyJson;
  }
    
    @Path("people/{id}")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String getPeopleById(@PathParam("id") int id) throws MalformedURLException, IOException{  
    URL url = new URL("https://swapi.co/api/people/"+id);
    HttpURLConnection con = (HttpURLConnection) url.openConnection();
    con.setRequestMethod("GET");
    con.setRequestProperty("Accept", "application/json;charset=UTF-8");
    con.setRequestProperty("User-Agent", "server"); //remember if you are using SWAPI
    Scanner scan = new Scanner(con.getInputStream());
    String jsonStr = null;
    if (scan.hasNext()) {
      jsonStr = scan.nextLine();
    }
    scan.close();
    
    JsonElement jsonElement = jsonParser.parse(jsonStr);
    String prettyJson = GSON.toJson(jsonElement);
    
    return prettyJson;
  }
 
}

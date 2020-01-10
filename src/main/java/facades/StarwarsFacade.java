package facades;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import entities.RenameMe;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import utils.MakeStarwars;
import utils.MakeStarwarsCallable;

/**
 *
 * Rename Class to a relevant name Add add relevant facade methods
 */
public abstract class StarwarsFacade implements Callable {

    private static StarwarsFacade instance;
    private static EntityManagerFactory emf;
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    private static final JsonParser jsonParser = new JsonParser();
    
    //Private Constructor to ensure Singleton
    private StarwarsFacade() {}    
    
    /**
     * 
     * @param _emf
     * @return an instance of this facade class.
     */
    public static StarwarsFacade getFacadeExample(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new StarwarsFacade() {
                @Override
                public Object call() throws Exception {
                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }
            };
        }
        return instance;
    }
    

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
     public static List<String> getAllStarwars() throws Exception{
      ExecutorService executor = Executors.newCachedThreadPool();
      List<String> urls = new ArrayList<String>();
      urls.add("https://swapi.co/api/people/1");
      urls.add("https://swapi.co/api/starships/9/");
      urls.add("https://swapi.co/api/planets/1/");
      urls.add("https://swapi.co/api/vehicles/14/");
      urls.add("https://swapi.co/api/species/4/");
      List<Future<MakeStarwars>> futures = new ArrayList<>();

    for (String url : urls) {
      MakeStarwarsCallable ms = new MakeStarwarsCallable(url);
      Future<MakeStarwars> future = executor.submit(ms);
      futures.add(future);
    }
    List<String> results = new ArrayList<>();
    for (Future<MakeStarwars> f : futures) {
        
      MakeStarwars ms = f.get();
      results.add(ms.getResult());
    }
    return results;
  }     

}



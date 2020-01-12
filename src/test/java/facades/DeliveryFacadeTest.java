package facades;

import entities.Cargo;
import entities.Truck;
import entities.Delivery;
import utils.EMF_Creator;
import entities.RenameMe;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import utils.Settings;
import utils.EMF_Creator.DbSelector;
import utils.EMF_Creator.Strategy;

//Uncomment the line below, to temporarily disable this test
//@Disabled
public class DeliveryFacadeTest {
    
    

    private static EntityManagerFactory emf;
    private static DeliveryFacade facade;

    public DeliveryFacadeTest() {
    }

    //@BeforeAll
    public static void setUpClass() {
        emf = EMF_Creator.createEntityManagerFactory(
                "pu",
                "jdbc:mysql://localhost:3307/startcode_test?serverTimezone=CET",
                "dev",
                "ax2",
                EMF_Creator.Strategy.DROP_AND_CREATE);
        facade = DeliveryFacade.getDeliveryFacade(emf);
    }

    /*   **** HINT **** 
        A better way to handle configuration values, compared to the UNUSED example above, is to store those values
        ONE COMMON place accessible from anywhere.
        The file config.properties and the corresponding helper class utils.Settings is added just to do that. 
        See below for how to use these files. This is our RECOMENDED strategy
     */
    @BeforeAll
    public static void setUpClassV2() {
       emf = EMF_Creator.createEntityManagerFactory(DbSelector.TEST,Strategy.DROP_AND_CREATE);
       facade = DeliveryFacade.getDeliveryFacade(emf);
    }

    @AfterAll
    public static void tearDownClass() {
//        Clean up database after test is done or use a persistence unit with drop-and-create to start up clean on every test
    }

    // Setup the DataBase in a known state BEFORE EACH TEST
    //TODO -- Make sure to change the script below to use YOUR OWN entity class
    @BeforeEach
    public void setUp() throws ParseException {
        EntityManager em = emf.createEntityManager();
        try {
            
            /*
            em.persist(f);
            //em.persist(new RenameMe("aaa", "bbb"));

            em.getTransaction().commit();
            */
        } finally {
            em.close();
        }
    }
    
    @Test
    public void getFlightBySearchTest(){
           
    }

    @AfterEach
    public void tearDown() {
//        Remove any data after each test was run
    }


}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import dtomappers.FlightDTO;
import entities.Flight;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import org.eclipse.persistence.jpa.jpql.parser.DateTime;

/**
 *
 * @author jelle
 */
public class FlightFacade implements IFlightFacade {
    
    private static FlightFacade instance;
    private static EntityManagerFactory emf;
    
    //Private Constructor to ensure Singleton
    private FlightFacade() {}
    
     private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
     
    
    /**
     * 
     * @param _emf
     * @return an instance of this facade class.
     */
         public static FlightFacade getFlightFacade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new FlightFacade();
        }
        return instance;
    }
     
    @Override
    public List<FlightDTO> getAllFlights(){
        EntityManager em = getEntityManager();
        List<FlightDTO> flightDTOs = new ArrayList<FlightDTO>();
        try{
        //Date dateString = new Date(departureDate.toString());
        
            TypedQuery<Flight> query = em.createQuery("SELECT f FROM Flights f", Flight.class);

            List<Flight> flights = query.getResultList();
            
            for (int i = 0; i < flights.size(); i++) {
                flightDTOs.add(new FlightDTO(flights.get(i)));
                
            }
            
            return flightDTOs;
        } catch (ParseException ex) {
            Logger.getLogger(FlightFacade.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            em.close();
        }
        return flightDTOs;
    }
     
    @Override
    public List<FlightDTO> getFlightBySearch(String departure, String destination, Date departureDate) {
        EntityManager em = getEntityManager();
        
        List<FlightDTO> flightDTOs = new ArrayList<FlightDTO>();
        try{
        
            
            System.out.println("Printer den formaterede Date ude her: " + departureDate);
            
            TypedQuery<Flight> query = em.createQuery("SELECT f FROM Flights f WHERE f.departureAirportId.airportName = :departure AND f.arrivalAirportId.airportName = :arrival AND f.departureDate = :date", Flight.class)
                    .setParameter("departure", departure)
                    .setParameter("arrival", destination)
                    .setParameter("date", departureDate);

            List<Flight> flights = query.getResultList();
            
            for (int i = 0; i < flights.size(); i++) {
                flightDTOs.add(new FlightDTO(flights.get(i)));
                
            }
            return flightDTOs;
        } catch (ParseException ex) {
            Logger.getLogger(FlightFacade.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            em.close();
        }
        return flightDTOs;
    }
    
}

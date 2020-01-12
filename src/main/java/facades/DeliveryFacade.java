/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import dtomappers.DeliveryDTO;
import entities.Delivery;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

/**
 *
 * @author jelle
 */
public class DeliveryFacade implements IDeliveryFacade {
    
    private static DeliveryFacade instance;
    private static EntityManagerFactory emf;
    
    //Private Constructor to ensure Singleton
    private DeliveryFacade() {}
    
     private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
     
    
    /**
     * 
     * @param _emf
     * @return an instance of this facade class.
     */
         public static DeliveryFacade getDeliveryFacade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new DeliveryFacade();
        }
        return instance;
    }
     
    @Override
    public List<DeliveryDTO> getAllDeliveries(){
        EntityManager em = getEntityManager();
        List<DeliveryDTO> deliveryDTOs = new ArrayList<DeliveryDTO>();
        try{
        
            TypedQuery<Delivery> query = em.createQuery("SELECT d FROM Delivery d", Delivery.class);

            List<Delivery> deliveries = query.getResultList();
            
            for (int i = 0; i < deliveries.size(); i++) {
                deliveryDTOs.add(new DeliveryDTO(deliveries.get(i)));
                
            }
            
            return deliveryDTOs;
        }finally{
            em.close();
        }
    }
     /*
    @Override
    public List<PersonDTO> getFlightBySearch(String departure, String destination, Date departureDate) {
        EntityManager em = getEntityManager();
        
        List<PersonDTO> flightDTOs = new ArrayList<PersonDTO>();
        try{
        
            
            System.out.println("Printer den formaterede Date ude her: " + departureDate);
            
            TypedQuery<Person> query = em.createQuery("SELECT f FROM Flights f WHERE f.departureAirportId.airportName = :departure AND f.arrivalAirportId.airportName = :arrival AND f.departureDate = :date", Delivery.class)
                    .setParameter("departure", departure)
                    .setParameter("arrival", destination)
                    .setParameter("date", departureDate);

            List<Person> flights = query.getResultList();
            
            for (int i = 0; i < flights.size(); i++) {
                flightDTOs.add(new DeliveryDTO(flights.get(i)));
                
            }
            return flightDTOs;
        } catch (ParseException ex) {
            Logger.getLogger(DeliveryFacade.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            em.close();
        }
        return flightDTOs;
    }*/
    
}

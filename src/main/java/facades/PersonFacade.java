/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import dtomappers.PersonDTO;
import entities.Person;
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
public class PersonFacade implements IPersonFacade {
    
    private static PersonFacade instance;
    private static EntityManagerFactory emf;
    
    //Private Constructor to ensure Singleton
    private PersonFacade() {}
    
     private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
     
    
    /**
     * 
     * @param _emf
     * @return an instance of this facade class.
     */
         public static PersonFacade getPersonFacade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new PersonFacade();
        }
        return instance;
    }
     
    @Override
    public List<PersonDTO> getAllPersons(){
        EntityManager em = getEntityManager();
        List<PersonDTO> personDTOs = new ArrayList<PersonDTO>();
        try{
        
            TypedQuery<Person> query = em.createQuery("SELECT p FROM Person p", Person.class);

            List<Person> persons = query.getResultList();
            
            for (int i = 0; i < persons.size(); i++) {
                personDTOs.add(new PersonDTO(persons.get(i)));
                
            }
            
            return personDTOs;
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
            
            TypedQuery<Person> query = em.createQuery("SELECT f FROM Flights f WHERE f.departureAirportId.airportName = :departure AND f.arrivalAirportId.airportName = :arrival AND f.departureDate = :date", Person.class)
                    .setParameter("departure", departure)
                    .setParameter("arrival", destination)
                    .setParameter("date", departureDate);

            List<Person> flights = query.getResultList();
            
            for (int i = 0; i < flights.size(); i++) {
                flightDTOs.add(new PersonDTO(flights.get(i)));
                
            }
            return flightDTOs;
        } catch (ParseException ex) {
            Logger.getLogger(PersonFacade.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            em.close();
        }
        return flightDTOs;
    }*/
    
}

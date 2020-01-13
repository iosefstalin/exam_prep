/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import dtomappers.DeliveryDTO;
import dtomappers.TruckDTO;
import entities.Delivery;
import entities.Truck;
import java.util.ArrayList;
import java.util.Date;
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
     
    @Override
    public List<TruckDTO> getTrucksBySearch(Long truckId) {
        EntityManager em = getEntityManager();
        
        List<TruckDTO> truckDTOs = new ArrayList<TruckDTO>();
        try{
        
            
            System.out.println("Printer søge kriterier ud her: " + truckId);
            
            TypedQuery<Truck> query = em.createQuery("SELECT t FROM Truck t WHERE t.id = :truckId", Truck.class)
                    .setParameter("truckId", truckId);
                    

            List<Truck> trucks = query.getResultList();
            
            for (int i = 0; i < trucks.size(); i++) {
                truckDTOs.add(new TruckDTO(trucks.get(i)));
                
            }
            return truckDTOs;
        }finally{
            em.close();
        }
    }

    @Override
    public List<TruckDTO> getAllTrucks() {
        EntityManager em = getEntityManager();
        
        List<TruckDTO> truckDTOs = new ArrayList<TruckDTO>();
        try{
        
            
            
            
            TypedQuery<Truck> query = em.createQuery("SELECT t FROM Truck t", Truck.class);
                    

            List<Truck> trucks = query.getResultList();
            
            for (int i = 0; i < trucks.size(); i++) {
                truckDTOs.add(new TruckDTO(trucks.get(i)));
                
            }
            return truckDTOs;
        }finally{
            em.close();
        }
        
    }

    @Override
    public List<TruckDTO> getTrucksByDate(Date date) {
       EntityManager em = getEntityManager();
        
        List<TruckDTO> truckDTOs = new ArrayList<TruckDTO>();
        try{
        
            
            System.out.println("Printer søge kriterier ud her: " + date);
            
            TypedQuery<Truck> query = em.createQuery("SELECT t.truck FROM Delivery t WHERE t.date != :date", Truck.class)
                    .setParameter("date", date);
                    

            List<Truck> trucks = query.getResultList();
            
            for (int i = 0; i < trucks.size(); i++) {
                truckDTOs.add(new TruckDTO(trucks.get(i)));
                
            }
            return truckDTOs;
        }finally{
            em.close();
        }
    }


    
}

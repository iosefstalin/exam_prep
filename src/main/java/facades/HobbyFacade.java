/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import dtomappers.HobbyDTO;
import entities.Hobby;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

/**
 *
 * @author jelle
 */
public class HobbyFacade implements IHobbyFacade {
    
    private static HobbyFacade instance;
    private static EntityManagerFactory emf;
    
        //Private Constructor to ensure Singleton
    private HobbyFacade() {}
    
     private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
     
    
    /**
     * 
     * @param _emf
     * @return an instance of this facade class.
     */
         public static HobbyFacade getHobbyFacade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new HobbyFacade();
        }
        return instance;
    }

       @Override
    public List<HobbyDTO> getAllHobbies(){
        EntityManager em = getEntityManager();
        List<HobbyDTO> hobbyDTOs = new ArrayList<HobbyDTO>();
        try{
        
            TypedQuery<Hobby> query = em.createQuery("SELECT h FROM Hobby h", Hobby.class);

            List<Hobby> hobbies = query.getResultList();
            
            for (int i = 0; i < hobbies.size(); i++) {
                hobbyDTOs.add(new HobbyDTO(hobbies.get(i)));
                
            }
            
            return hobbyDTOs;
        }finally{
            em.close();
        }
    }
    
}

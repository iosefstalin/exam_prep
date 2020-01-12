/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import dtomappers.PersonDTO;
import java.util.List;

/**
 *
 * @author jelle
 */
public interface IPersonFacade {
    
    public List<PersonDTO> getAllPersons();
    
   // public List<PersonDTO> getPersonByPhone(String phone);
    
}

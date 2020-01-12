/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;


import dtomappers.HobbyDTO;
import java.util.List;

/**
 *
 * @author jelle
 */
public interface IHobbyFacade {
    public List<HobbyDTO> getAllHobbies();
    
}

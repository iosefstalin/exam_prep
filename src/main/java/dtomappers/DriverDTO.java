/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtomappers;

import entities.Driver;
import java.util.List;

/**
 *
 * @author jelle
 */
public class DriverDTO {
    
     private String name;

    public DriverDTO() {
    }

    public DriverDTO(Driver driver) {
        this.name = driver.getName();

    }
    
}

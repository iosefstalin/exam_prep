/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtomappers;

import entities.Cargo;


/**
 *
 * @author jelle
 */
public class CargoDTO {
    private String name;
    private String weight;
    private String units;

    public CargoDTO() {
    }

    public CargoDTO(Cargo cargo) {
        this.name = cargo.getName();
        this.units = cargo.getUnits();
        this.weight = cargo.getWeight();
    }

    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getUnits() {
        return units;
    }

    public void setUnits(String units) {
        this.units = units;
    }
    
}

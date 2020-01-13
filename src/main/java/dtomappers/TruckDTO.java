/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtomappers;

import entities.Cargo;
import entities.Truck;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jelle
 */
public class TruckDTO {
    
    private Long truckId;
    private String name;
    private String capacity;
    private List<DriverDTO> drivers = new ArrayList<>();

    public TruckDTO() {
    }

    public TruckDTO(Truck truck) {
        this.truckId = truck.getId();
        this.name = truck.getName();
        this.capacity = truck.getCapacity();
        
           for (int i = 0; i < truck.getDriver().size(); i++) {
            this.drivers.add(new DriverDTO(truck.getDriver().get(i)));
            
        }
    }

    public TruckDTO(Long truckId) {
        this.truckId = truckId;
    }
    


    
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    public List<DriverDTO> getDrivers() {
        return drivers;
    }

    public void setDrivers(List<DriverDTO> drivers) {
        this.drivers = drivers;
    }

    public Long getTruckId() {
        return truckId;
    }

    public void setTruckId(Long truckId) {
        this.truckId = truckId;
    }


    
}

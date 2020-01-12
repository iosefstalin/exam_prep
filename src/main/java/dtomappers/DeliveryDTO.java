/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtomappers;

import entities.Delivery;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author jelle
 */
public class DeliveryDTO {
    private Date date;
    private String departureLocation;
    private String destination;
    private TruckDTO truck;
    private List<CargoDTO> cargo = new ArrayList<>();

    

    public DeliveryDTO() {
    }

    public DeliveryDTO(Delivery delivery) {
        this.date = delivery.getDate();
        this.departureLocation = delivery.getDepartureLocation();
        this.destination = delivery.getDestination();
        this.truck = new TruckDTO(delivery.getTruck());
        
          for (int i = 0; i < delivery.getDeliveryId().size(); i++) {
            this.cargo.add(new CargoDTO(delivery.getDeliveryId().get(i)));
            
        }
        
    }

    

}

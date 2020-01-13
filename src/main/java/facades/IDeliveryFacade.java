/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import dtomappers.DeliveryDTO;
import dtomappers.TruckDTO;
import java.util.Date;
import java.util.List;

/**
 *
 * @author jelle
 */
public interface IDeliveryFacade {
    
    public List<DeliveryDTO> getAllDeliveries();
    public List<TruckDTO> getTrucksBySearch(Long truckId);
    public List<TruckDTO> getAllTrucks();
    
}

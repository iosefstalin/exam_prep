/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import dtomappers.FlightDTO;
import java.util.Date;
import java.util.List;
import org.eclipse.persistence.jpa.jpql.parser.DateTime;

/**
 *
 * @author jelle
 */
public interface IFlightFacade {
    
    public List<FlightDTO> getAllFlights();
    public List<FlightDTO> getFlightBySearch(String departure, String destination, Date departureDate);
    
}

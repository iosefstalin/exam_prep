/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtomappers;

import entities.Flight;
import static java.lang.String.format;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;
import org.eclipse.persistence.jpa.jpql.parser.DateTime;

/**
 *
 * @author jelle
 */
public class FlightDTO {
    private Date departureTime;
    //private Date departureTime;
    private Date departureDate;
    private Long flightDuration;
    private String departureAirportName;
    private String departureAirportCode;
    private String arrivalAirportName;
    private String arrivalAirportCode;
    private String airline;
    private double price;

    public FlightDTO() {
    }
       
    
    public FlightDTO(Flight flight) throws ParseException{
        SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat formatTime = new SimpleDateFormat("HH:mm:ss");
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        String flightDate = formatDate.format(flight.getDepartureDate());
        String flightTime = formatTime.format(flight.getDepartureTime());
   
        this.departureTime = formatter.parse(flightDate + " " + flightTime);
        this.flightDuration = flight.getFlightDuration();
        this.departureAirportName = flight.getDepartureAirportId().getAirportName();
        this.departureAirportCode = flight.getDepartureAirportId().getAirportCode();
        this.arrivalAirportName = flight.getArrivalAirportId().getAirportName();
        this.arrivalAirportCode = flight.getArrivalAirportId().getAirportCode();
        this.airline = flight.getAirline().getAirlineName();
        this.price = flight.getPrice();
    }

    public FlightDTO(String departureAirportName, String arrivalAirportName, Date departureDate) {
        this.departureAirportName = departureAirportName;
        this.arrivalAirportName = arrivalAirportName;
        this.departureDate = departureDate;
    }
    

    public Date getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Time departureTime) {
        this.departureTime = departureTime;
    }

    public Long getFlightDuration() {
        return flightDuration;
    }

    public void setFlightDuration(Long flightDuration) {
        this.flightDuration = flightDuration;
    }

    public String getDepartureAirportName() {
        return departureAirportName;
    }

    public void setDepartureAirportName(String departureAirportName) {
        this.departureAirportName = departureAirportName;
    }

    public String getDepartureAirportCode() {
        return departureAirportCode;
    }

    public void setDepartureAirportCode(String departureAirportCode) {
        this.departureAirportCode = departureAirportCode;
    }

    public String getArrivalAirportName() {
        return arrivalAirportName;
    }

    public void setArrivalAirportName(String arrivalAirportName) {
        this.arrivalAirportName = arrivalAirportName;
    }

    public String getArrivalAirportCode() {
        return arrivalAirportCode;
    }

    public void setArrivalAirportCode(String arrivalAirportCode) {
        this.arrivalAirportCode = arrivalAirportCode;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }

    public String getAirline() {
        return airline;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }

    
    
    
}

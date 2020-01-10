/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.sql.Time;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import org.eclipse.persistence.jpa.jpql.parser.DateTime;

/**
 *
 * @author jelle
 */
@Entity(name = "Flights")

// TODO namedQueries
@NamedQueries({
@NamedQuery(name = "Flights.deleteAllRows", query = "DELETE from Flights"),
@NamedQuery(name = "Flights.getAllRows", query = "SELECT f from Flights f")})

@Table(name = "Flights")
public class Flight implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    @Column(name = "id")
    private Long id;
    
    @ManyToOne(cascade = { CascadeType.PERSIST})
    @JoinColumn(name = "departureAirportId")
    private Airport departureAirportId;
    
    @ManyToOne(cascade = {CascadeType.PERSIST})
    @JoinColumn(name = "arrivalAirportId")
    private Airport arrivalAirportId;
    
    @Column(name = "departureTime")
    @Temporal (TemporalType.TIME)
    private java.util.Date departureTime;
    
    @Column(name = "departureDate")
    @Temporal (TemporalType.DATE)
    private java.util.Date departureDate;
    
    @Column(name = "flightDuration")
    private Long flightDuration;
    
    @ManyToOne(cascade = {CascadeType.PERSIST})
    @JoinColumn(name = "airline")
    private Airline airline;
    
    @Column(name = "price")
    private double price;
    

    public Flight() {
    }

    public Flight(Airport departureAirportId, Airport arrivalAirportId, Date departureTime, Date departureDate, Long flightDuration, Airline airlineId, double price) {
        this.departureAirportId = departureAirportId;
        this.arrivalAirportId = arrivalAirportId;
        this.departureTime = departureTime;
        this.departureDate = departureDate;
        this.flightDuration = flightDuration;
        this.airline = airlineId;
        this.price = price;
    }
    
    
    
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
   

    public Airport getDepartureAirportId() {
        return departureAirportId;
    }

    public void setDepartureAirportId(Airport departureAirportId) {
        this.departureAirportId = departureAirportId;
    }

    public Airport getArrivalAirportId() {
        return arrivalAirportId;
    }

    public void setArrivalAirportId(Airport arrivalAirportId) {
        this.arrivalAirportId = arrivalAirportId;
    }

    public Long getFlightDuration() {
        return flightDuration;
    }

    public void setFlightDuration(Long flightDuration) {
        this.flightDuration = flightDuration;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Time departureTime) {
        this.departureTime = departureTime;
    }

    public Date getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }

    public Airline getAirline() {
        return airline;
    }

    public void setAirline(Airline airline) {
        this.airline = airline;
    }

    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import org.eclipse.persistence.jpa.jpql.parser.DateTime;

/**
 *
 * @author jelle
 */
@Entity(name = "Delivery")

// TODO namedQueries
@NamedQueries({
@NamedQuery(name = "Delivery.deleteAllRows", query = "DELETE from Delivery"),
@NamedQuery(name = "Delivery.getAllRows", query = "SELECT d from Delivery d")})

@Table(name = "Delivery")
public class Delivery implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    @Column(name = "id")
    private Long id;
    
    @ManyToOne(cascade = { CascadeType.PERSIST})
    @JoinColumn(name = "truck")
    private Truck truck;
    
    @OneToMany(cascade = { CascadeType.PERSIST})
    @JoinColumn(name = "delivery_id")
    private List<Cargo> deliveryId = new ArrayList<>();
    
    @Column(name = "shipping_date")
    @Temporal (TemporalType.DATE)
    private Date date;
    
    @Column(name = "departure_location")
    private String departureLocation;
    
    @Column(name = "destination")
    private String destination;
   

    public Delivery() {
    }

    public Delivery(Long id, Date date, String departureLocation, String destination, Truck trucks, List<Cargo> cargo) {
        this.id = id;
        this.date = date;
        this.departureLocation = departureLocation;
        this.destination = destination;
        this.truck = truck;
        this.deliveryId = cargo;
    }




    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }



    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDepartureLocation() {
        return departureLocation;
    }

    public void setDepartureLocation(String departureLocation) {
        this.departureLocation = departureLocation;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Truck getTruck() {
        return truck;
    }

    public void setTruck(Truck truck) {
        this.truck = truck;
    }

    public List<Cargo> getDeliveryId() {
        return deliveryId;
    }

    public void setDeliveryId(List<Cargo> Cargo) {
        this.deliveryId = Cargo;
    }
    
}

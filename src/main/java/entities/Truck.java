/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author jelle
 */
@Entity(name = "Truck")

@NamedQueries({
@NamedQuery(name = "Truck.deleteAllRows", query = "DELETE from Truck"),
@NamedQuery(name = "Truck.getAllRows", query = "SELECT t from Truck t")})

@Table(name = "Truck")
public class Truck implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @OneToMany(mappedBy="truck", cascade = {CascadeType.PERSIST})
    @JoinColumn(name = "delivery")
    private List<Delivery> delivery;
    @ManyToMany(cascade = {CascadeType.PERSIST})
    @JoinColumn(name = "driver")
    private List<Driver> driver = new ArrayList<>();   
    @Column(name = "name")
    private String name;
    @Column(name = "capacity")
    private String capacity;

    public Truck() {
    }

    public Truck(String name, String capacity, List<Delivery> delivery, List<Driver> driver) {
        this.name = name;
        this.capacity = capacity;
        this.delivery = delivery;
        this.driver = driver;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Delivery> getDelivery() {
        return delivery;
    }

    public void setDelivery(List<Delivery> delivery) {
        this.delivery = delivery;
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

    public List<Driver> getDriver() {
        return driver;
    }

    public void setDriver(List<Driver> driver) {
        this.driver = driver;
    }
  
    
    
}

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
import javax.persistence.Table;

/**
 *
 * @author jelle
 */
@Entity(name = "Driver")

// TODO namedQueries
@NamedQueries({
@NamedQuery(name = "Driver.deleteAllRows", query = "DELETE from Driver"),
@NamedQuery(name = "Ddriver.getAllRows", query = "SELECT d from Driver d")})

@Table(name = "Driver")
public class Driver implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @ManyToMany(mappedBy="driver", cascade = {CascadeType.PERSIST})
    @JoinColumn(name = "truck")
    private List<Truck> truck;
    @Column(name = "name")
    private String name;


    public Driver() {
    }

    public Driver(Long id, String name) {
        this.id = id;
        this.name = name;
    }
    
    
    public Long getId() {
        return id;
    }

    public Driver(String name) {
        this.name = name;
    }

    public List<Truck> getTruck() {
        return truck;
    }

    public void setTruck(List<Truck> truck) {
        this.truck = truck;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    
    
}

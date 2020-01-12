/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtomappers;

import entities.Hobby;
import entities.Person;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jelle
 */
public class PersonDTO {
    private String email;
    private String phone;
    private String firstName;
    private String lastName;
    private String Street;
    private String city;
    private String zip;
    private List<HobbyDTO> hobbies = new ArrayList<>();
    private String hobbyName;
    private String hobbyDescription;
    

    public PersonDTO() {
    }

    public PersonDTO(Person person) {
        this.email = person.getEmail();
        this.phone = person.getPhone();
        this.firstName = person.getFirstName();
        this.lastName = person.getLastName();
        this.Street = person.getAddressId().getStreet();
        this.city = person.getAddressId().getCity();
        this.zip = person.getAddressId().getZip();
        
        for (int i = 0; i < person.getHobbiesId().size(); i++) {
            this.hobbies.add(new HobbyDTO(person.getHobbiesId().get(i)));
            
        }
        
        
        //this.hobbyName = person.getHobbiesId().get(0).getName();
        //this.hobbyDescription = person.getHobbiesId().get(0).getDescription();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getStreet() {
        return Street;
    }

    public void setStreet(String Street) {
        this.Street = Street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getHobbyName() {
        return hobbyName;
    }

    public void setHobbyName(String hobbyName) {
        this.hobbyName = hobbyName;
    }

    public String getHobbyDescription() {
        return hobbyDescription;
    }

    public void setHobbyDescription(String hobbyDescription) {
        this.hobbyDescription = hobbyDescription;
    }    

    public List<HobbyDTO> getHobbies() {
        return hobbies;
    }

    public void setHobbies(List<HobbyDTO> hobbies) {
        this.hobbies = hobbies;
    }


}

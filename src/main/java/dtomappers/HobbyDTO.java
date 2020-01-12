/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtomappers;

import entities.Hobby;

/**
 *
 * @author jelle
 */
public class HobbyDTO {
    
    private String hobbyName;
    private String hobbyDescription;

    public HobbyDTO() {
    }

    public HobbyDTO(Hobby hobby) {
        this.hobbyName = hobby.getName();
        this.hobbyDescription = hobby.getDescription();
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
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.util.concurrent.Callable;


/**
 *
 * @author jelle
 */
public class MakeStarwarsCallable implements Callable<MakeStarwars> {
  

     MakeStarwars ms;

  public MakeStarwarsCallable(String url) {
    ms = new MakeStarwars(url);
  }
    /*int length;
    MakeStarwarsCallable(int length){
        this.length = length;
    }*/
    
    @Override
    public MakeStarwars call() throws Exception {
        ms.fetchStarwars();
        return ms;
    }
    
    
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.iteria.parques.front.view;

import co.com.iteria.parques.front.modelo.Parque;
import java.util.ArrayList;
import java.util.Iterator;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.json.JsonArray;
import javax.json.*;



/**
 *
 * @author Usuario
 */

@ManagedBean
public class ParquesEditView {
    
   private String seletedId;
   private Parque seletedPark;

    public String getSeletedId() {
        return seletedId;
    }

    public void setSeletedId(String seletedId) {
        this.seletedId = seletedId;
    }

    public Parque getSeletedPark() {
        return seletedPark;
    }

    public void setSeletedPark(Parque seletedPark) {
        this.seletedPark = seletedPark;
    }

 
  
   
    
   public void init(){
       Client client = ClientBuilder.newClient();
       WebTarget rs= client.target("https://private-3305d-parques7.apiary-mock.com/parks/parkId");
       
       JsonObject jsonOj=(JsonObject) rs.resolveTemplate("id", seletedId).
               request(MediaType.APPLICATION_JSON).get(JsonObject.class);
       
       seletedPark=Parque.fromJson(jsonOj);
       
   }
    
    
}

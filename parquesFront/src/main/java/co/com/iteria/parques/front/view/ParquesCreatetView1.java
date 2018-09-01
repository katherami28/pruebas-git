/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.iteria.parques.front.view;

import co.com.iteria.parques.front.modelo.Parque;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.json.JsonArray;
import javax.json.*;



/**
 *
 * @author Usuario
 */

@ManagedBean
public class ParquesCreatetView1 {
    
   
   private Parque park;

    public Parque getPark() {
        return park;
    }

    public void setPark(Parque park) {
        this.park = park;
    }


 
   
    
   public void init(){
          Client client = ClientBuilder.newClient();
       WebTarget rs= client.target("https://private-3305d-parques7.apiary-mock.com/parks/parkId");
       
       
        JsonObject json = Json.createObjectBuilder()                
                .add("name", park.getNombre())
                .add("state", park.getState())
                .add("capacity", park.getCapacity())                
                .build();   
       
       park=Parque.fromJson(json);
       
   }
    
    
}

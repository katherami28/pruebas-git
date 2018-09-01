/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.iteria.parques.front.modelo;

import javax.json.*;

/**
 *
 * @author Usuario
 */
public class Parque {
    
    private String id;
    private String nombre;
    private String state;
    private int capacity;
    private String status;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

 

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

       public static Parque fromJson(JsonObject val){
             Parque nuevo = new Parque();
            nuevo.setId(val.getString("id"));
            nuevo.setNombre(val.getString("name"));
            nuevo.setState(val.getString("state"));
            nuevo.setCapacity(val.getInt("capacity"));
            nuevo.setStatus(val.getString("status"));
                       
            return nuevo;
    }
   

   
    
}

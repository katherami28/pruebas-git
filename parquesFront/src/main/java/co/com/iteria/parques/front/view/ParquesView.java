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
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.json.JsonArray;
import javax.json.*;
import javax.ws.rs.core.Response;



/**
 *
 * @author Usuario
 */

@ManagedBean
public class ParquesView {
    
    private List<Parque> parques = new ArrayList<>();

    public List<Parque> getParques() {
        return parques;
    }

    public void setParques(List<Parque> parques) {
        this.parques = parques;
    }

   
    
    public String consultaParques(){
        Client cliente = ClientBuilder.newClient();
        WebTarget rs=cliente.target("https://private-3305d-parques7.apiary-mock.com/parks?status=");
        
        
        JsonArray jsonarray= (JsonArray)rs.request(MediaType.APPLICATION_JSON).get(JsonArray.class);
        
        Iterator iter= jsonarray.iterator();
        while(iter.hasNext()){
            JsonObject val =(JsonObject)iter.next();
            parques.add(Parque.fromJson(val));
        }
        
        return "";
    }
    
    public void eliminarParque(Parque parque) {
               Client cliente = ClientBuilder.newClient();
        WebTarget rs=cliente.target("https://private-3305d-parques7.apiary-mock.com/parks/parkId");
        
            Response response = rs.resolveTemplate("id", parque.getId())
                    .request(MediaType.APPLICATION_JSON).delete();
          
            if(response.getStatus() == 204){
                parques.remove(parque);
                FacesContext.getCurrentInstance()
                    .addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Información", "Se elimino parque"));
            }else{
                FacesContext.getCurrentInstance()
                    .addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", "Error al eliminar parque"));
            }
            
        }

    
}

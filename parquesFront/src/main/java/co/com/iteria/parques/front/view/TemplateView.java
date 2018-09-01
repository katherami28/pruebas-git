/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.iteria.parques.front.view;


import java.io.Serializable;
import java.util.Locale;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;


/**
 *
 * @author Usuario
 */
@ManagedBean
@SessionScoped
public class TemplateView implements Serializable{
    
    public static final String LANG_ES="es";
     public static final String LANG_EN="en";

   private String lenguage=null;

    public String getLenguage() {
        return lenguage;
    }
    
     public void setLenguage(String lenguage) {
        this.lenguage = lenguage;
    }
     
      @PostConstruct
    public void init(){
          System.out.println(Locale.getDefault());
        UIViewRoot vr =FacesContext.getCurrentInstance().getViewRoot();
        lenguage=vr.getLocale().getLanguage();
    }
   
   public void onLangChange(ValueChangeEvent vc){
       UIViewRoot vr = FacesContext.getCurrentInstance().getViewRoot();
       
       if(LANG_ES.equals(vc.getNewValue())){
           vr.setLocale(new Locale(LANG_ES));
       }else{
           vr.setLocale(Locale.US);
       }
   }
}

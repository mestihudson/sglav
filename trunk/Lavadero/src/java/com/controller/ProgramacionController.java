/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.entity.Programacion;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.DefaultScheduleEvent;
import org.primefaces.model.DefaultScheduleModel;
import org.primefaces.model.LazyScheduleModel;
import org.primefaces.model.ScheduleEvent;
import org.primefaces.model.ScheduleModel;

/**
 *
 * @author ASUS
 */
@ManagedBean
@SessionScoped
public class ProgramacionController implements Serializable{

    List<Programacion> programaciones=new LinkedList();
    
    Programacion programacion=new Programacion();
    
   
    private ScheduleModel lavadosProgramados;
    private ScheduleEvent event = new DefaultScheduleEvent();
    
    /**
     * Creates a new instance of ProgramacionController
     */
    public ProgramacionController() {
    }
    

   
    @PostConstruct
    public void init() {
         
        lavadosProgramados = new DefaultScheduleModel();
       // lavadosProgramados.addEvent(new DefaultScheduleEvent("Champions League Match", previousDay8Pm(), previousDay11Pm()));
             
          
    }
    
    public void addEvent(ActionEvent actionEvent) {
        if(event.getId() == null)
            lavadosProgramados.addEvent(event);
        else
            lavadosProgramados.updateEvent(event);
         
        event = new DefaultScheduleEvent();
    }
    
    public Date getRandomDate(Date base) {
        Calendar date = Calendar.getInstance();
        date.setTime(base);
        date.add(Calendar.DATE, ((int) (Math.random()*30)) + 1);    //set random day of month
         
        return date.getTime();
    }
    
    public void onEventSelect(SelectEvent selectEvent) {
        event = (ScheduleEvent) selectEvent.getObject();
    }
     
    public void onDateSelect(SelectEvent selectEvent) {
        event = new DefaultScheduleEvent("", (Date) selectEvent.getObject(), (Date) selectEvent.getObject());
    }
    //se deben listar las programaciones  posteriores a la fecha

    /**
     * @return the lazyEventModel
     */
    public ScheduleModel getLavadosProgramados() {
        return lavadosProgramados;
    }

    /**
     * @param lazyEventModel the lazyEventModel to set
     */
    public void setLavadosProgramados(ScheduleModel lazyEventModel) {
        this.lavadosProgramados = lazyEventModel;
    }

    /**
     * @return the event
     */
    public ScheduleEvent getEvent() {
        return event;
    }

    /**
     * @param event the event to set
     */
    public void setEvent(ScheduleEvent event) {
        this.event = event;
    }
    
    
    
}

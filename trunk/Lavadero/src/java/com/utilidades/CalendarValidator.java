/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utilidades;

import java.util.Calendar;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 *
 * @author Jcmm
 */
@FacesValidator("calendarValidator")
public class CalendarValidator implements Validator{
    Calendar fecha = Calendar.getInstance();    
    
    @Override    
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
    java.util.Date date2 = (java.util.Date) value;

    if (date2.after(fecha.getTime())) { 
            throw new ValidatorException(new FacesMessage("Fecha debe ser anterio o igual a la actual")); // Btw: I wonder how that makes sense... That's actually not a validation error.
            } else {
                //throw new ValidatorException(new FacesMessage("date dont figure in the database"));
            } 
    }   
    
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dentalspa.timer;

import com.dentalspa.facades.CitaFacadeLocal;
import com.dentalspa.jpa.Cita;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Schedule;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;

/**
 *
 * @author Angel
 */
@Stateless
@LocalBean
public class ChecarCitasEJB {
    @EJB
    CitaFacadeLocal citaFacade;
    @Schedule(minute = "0", second = "0", dayOfMonth = "*", month = "*", year = "*", hour = "9-17", dayOfWeek = "Mon-Fri")
    public void myTimer() {
        List<Cita> citas = citaFacade.listAll();
        Date now = new Date();
        
        for(Cita cita: citas){
            Long diferencia = cita.getFechaCita().getTime()-now.getTime();
            if(diferencia> 0 && diferencia < 60*60*1000){
                
            }        
        }
    }
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}

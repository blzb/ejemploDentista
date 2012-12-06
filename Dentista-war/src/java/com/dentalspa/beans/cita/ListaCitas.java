/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dentalspa.beans.cita;

import com.dentalspa.facades.CitaFacadeLocal;
import com.dentalspa.jpa.Cita;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Angel
 */
@ManagedBean
@RequestScoped
public class ListaCitas {
    @EJB
    CitaFacadeLocal citaFacade;
    
    public List<Cita> getCitas(){
        return citaFacade.listAll();
    }
    /**
     * Creates a new instance of ListarCitas
     */
    public ListaCitas() {
    }
}

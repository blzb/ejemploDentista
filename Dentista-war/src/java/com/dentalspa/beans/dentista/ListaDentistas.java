/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dentalspa.beans.dentista;

import com.dentalspa.facades.DentistaFacadeLocal;
import com.dentalspa.jpa.Dentista;
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
public class ListaDentistas {
    @EJB
    DentistaFacadeLocal dentistaFacade;
    public List<Dentista> getDentistas(){
        return dentistaFacade.listAll();
    }
    /**
     * Creates a new instance of ListaDentistas
     */
    public ListaDentistas() {
    }
}

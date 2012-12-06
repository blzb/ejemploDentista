/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dentalspa.beans.dentista;

import com.dentalspa.facades.DentistaFacadeLocal;
import com.dentalspa.jpa.Dentista;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Angel
 */
@ManagedBean
@RequestScoped
public class CrearDentista {
    private String especialidad;
    private String nombre;
    @EJB
    private DentistaFacadeLocal dentistaFacade;

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String guardarDentista(){
        Dentista dentista= new Dentista();
        dentista.setEspecialidad(especialidad);
        dentista.setNombre(nombre);
        dentistaFacade.create(dentista);
        return "/dentista/listarDentistas";
    }
    /**
     * Creates a new instance of CrearDentista
     */
    public CrearDentista() {
    }
}

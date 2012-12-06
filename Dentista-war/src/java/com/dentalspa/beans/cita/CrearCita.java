/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dentalspa.beans.cita;

import com.dentalspa.facades.CitaFacadeLocal;
import com.dentalspa.facades.UsuarioFacadeLocal;
import java.util.Date;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Angel
 */
@ManagedBean
@RequestScoped
public class CrearCita {
    private Long idUsuario;
    private Long idDentista;
    private Date fecha;
    @EJB
    private CitaFacadeLocal citaFacade;

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Long getIdDentista() {
        return idDentista;
    }

    public void setIdDentista(Long idDentista) {
        this.idDentista = idDentista;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    public String guardarCita(){
        citaFacade.asignarCita(idUsuario, idDentista, fecha);
        return "/citas/listarCitas";
    }
    /**
     * Creates a new instance of CrearCita
     */
    public CrearCita() {
        
    }
}

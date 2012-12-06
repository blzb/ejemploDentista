/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dentalspa.facades;

import com.dentalspa.jpa.Cita;
import java.util.Date;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Angel
 */
@Local
public interface CitaFacadeLocal {
    public void asignarCita(Long idUsuario, Long idDentista, Date fecha);
    public List<Cita> listAll();
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dentalspa.facades;

import com.dentalspa.jpa.Cita;
import com.dentalspa.jpa.Dentista;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Angel
 */
@Local
public interface DentistaFacadeLocal {
    public List<Dentista> listAll();
    public void create(Dentista dentista);
    public List<Cita> getCitas(Long id);
    public Dentista get(Long id);
    
    
}

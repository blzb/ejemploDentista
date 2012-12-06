/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dentalspa.facades;

import com.dentalspa.jpa.Cita;
import com.dentalspa.jpa.Usuario;
import java.util.Date;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Angel
 */
@Local
public interface UsuarioFacadeLocal {
    public void create(Usuario usuario);
    public List<Usuario> listAll();
    public Usuario get(Long id);
    public List<Cita> getCitas(Long id);    
}

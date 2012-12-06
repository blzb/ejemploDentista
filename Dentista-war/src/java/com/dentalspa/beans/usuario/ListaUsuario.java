/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dentalspa.beans.usuario;

import com.dentalspa.facades.UsuarioFacadeLocal;
import com.dentalspa.jpa.Usuario;
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
public class ListaUsuario {
    @EJB
    UsuarioFacadeLocal usuarioFacade;
    
    /**
     * Creates a new instance of ListaUsuario
     */
    public ListaUsuario() {
    }
    public List<Usuario> getUsuarios(){
        return usuarioFacade.listAll();
    }
}

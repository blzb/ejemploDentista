/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dentalspa.beans.usuario;

import com.dentalspa.facades.UsuarioFacadeLocal;
import com.dentalspa.jpa.Usuario;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Angel
 */
@ManagedBean
@RequestScoped
public class CrearUsuario {
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    @EJB
    UsuarioFacadeLocal usuarioFacade;
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }
    public String guardar(){
        Usuario usuario = new Usuario();
        usuario.setNombre(nombre);
        usuario.setApellidoMAterno(apellidoMaterno);
        usuario.setApellidoPaterno(apellidoPaterno);
        usuarioFacade.create(usuario);
        return "/usuario/listarUsuarios";
    }
    /**
     * Creates a new instance of CrearUsuario
     */
    public CrearUsuario() {
    }
}

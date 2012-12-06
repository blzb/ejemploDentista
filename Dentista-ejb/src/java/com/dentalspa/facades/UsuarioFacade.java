/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dentalspa.facades;

import com.dentalspa.jpa.Cita;
import com.dentalspa.jpa.Dentista;
import com.dentalspa.jpa.Usuario;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Angel
 */
@Stateless
public class UsuarioFacade implements UsuarioFacadeLocal {
     @PersistenceContext
     EntityManager em;
     @EJB
     DentistaFacadeLocal dentistaFacade;
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @Override
         public void create(Usuario usuario){
             em.persist(usuario);
         }
    @Override
    public List<Usuario> listAll(){
        return em.createQuery("Select u from Usuario u").getResultList();
    }
    @Override
    public Usuario get(Long id){
        return em.find(Usuario.class, id);
    }
    @Override
    public List<Cita> getCitas(Long id){
        Usuario usuario = em.find(Usuario.class, id);
        return usuario.getCitas();
    }


}

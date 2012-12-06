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
public class CitaFacade implements CitaFacadeLocal {
    @PersistenceContext
    EntityManager em;
    @EJB
    DentistaFacadeLocal dentistaFacade;
    @EJB
    UsuarioFacadeLocal usuarioFacade;
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @Override
    public void asignarCita(Long idUsuario, Long idDentista, Date fecha){
        Usuario u = usuarioFacade.get(idUsuario);
        Dentista d = dentistaFacade.get(idDentista);
        Cita cita = new Cita();
        cita.setDentista(d);
        cita.setUsuario(u);
        cita.setFechaCita(fecha);
        em.persist(cita);
    }
    @Override
    public List<Cita> listAll(){
        return em.createQuery("Select c from Cita c").getResultList();
    }
}

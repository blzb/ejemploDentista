/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dentalspa.facades;

import com.dentalspa.jpa.Cita;
import com.dentalspa.jpa.Dentista;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Angel
 */
@Stateless
public class DentistaFacade implements DentistaFacadeLocal {
    @PersistenceContext
    EntityManager em;
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @Override
    public List<Dentista> listAll(){
    return em.createQuery("Select d from Dentista d").getResultList();
}
    @Override
    public void create(Dentista dentista){
        em.persist(dentista);
    }
    @Override
    public List<Cita> getCitas(Long id){
        Dentista dentista = em.find(Dentista.class , id);
        return dentista.getCitasAgendadas();
    }
    
    @Override
    public Dentista get(Long id){
        return em.find(Dentista.class, id);
    }
}

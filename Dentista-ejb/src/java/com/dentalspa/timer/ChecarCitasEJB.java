/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dentalspa.timer;

import com.dentalspa.facades.CitaFacadeLocal;
import com.dentalspa.jpa.Cita;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.Schedule;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.jms.Connection;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Session;
import javax.jms.TextMessage;

/**
 *
 * @author Angel
 */
@Stateless
@LocalBean
public class ChecarCitasEJB {

    @Resource(mappedName = "queueConnectionFactory")
    javax.jms.QueueConnectionFactory queueConnectionFactory;
    @Resource(mappedName = "jms/testQueue")
    javax.jms.Queue queue;
    @EJB
    CitaFacadeLocal citaFacade;

    @Schedule(minute = "0", second = "0", dayOfMonth = "*", month = "*", year = "*", hour = "9-17", dayOfWeek = "Mon-Fri")
    public void myTimer() {
        List<Cita> citas = citaFacade.listAll();
        Date now = new Date();
        Connection connection = null;
        try {
            connection = queueConnectionFactory.createConnection();

            for (Cita cita : citas) {
                Long diferencia = cita.getFechaCita().getTime() - now.getTime();
                if (diferencia > 0 && diferencia < 60 * 60 * 1000) {

                    Session session = connection.createSession(false,
                            Session.AUTO_ACKNOWLEDGE);
                    //ObjectMessage message = session.createObjectMessage(cita);
                    TextMessage message = session.createTextMessage(cita.getDentista().getNombre());
                    MessageProducer producer = session.createProducer(queue);
                    producer.send(message);
                    producer.close();
                    session.close();
                }
            }
        } catch (JMSException ex) {
        } finally {
            try{
            connection.close();
            }catch(Exception e){
                e.printStackTrace();
            }
        }

    }
// Add business logic below. (Right-click in editor and choose
// "Insert Code > Add Business Method")
}

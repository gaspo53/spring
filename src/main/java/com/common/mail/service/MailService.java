/*
 * Fluxit S.A
 * La Plata - Buenos Aires - Argentina
 * http://www.fluxit.com.ar
 * Author: Gaspar Rajoy
 * Date:  Mar 15, 2013 - 3:37:09 PM
 */
package com.common.mail.service;


import java.util.List;

import org.springframework.stereotype.Service;

import com.common.model.Mail;


/**

 * @author Gaspar Rajoy - Flux IT

 **/

@Service
public interface MailService {

	
	   public void enqueue(Mail mail);
	   public void processQueue(); //Sends all unsent mails
	   public void send(Mail mail);
	   public void delete(Mail mail);
	   public void delete(Long id);
	   public void send(Long mailID);
	   public Mail update(Mail mail);
	   public Mail getMail(Long id);
	   public int queueSize(); //Number of mails ready to send
	   public List<Mail> getUnsent();
	   public List<Mail> getAll();
	   

}

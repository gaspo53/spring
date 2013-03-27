/*
 * Fluxit S.A
 * La Plata - Buenos Aires - Argentina
 * http://www.fluxit.com.ar
 * Author: Gaspar Rajoy
 * Date:  Mar 22, 2013 - 12:32:40 PM
 */
package com.common.tasks;

import org.springframework.beans.factory.annotation.Autowired;

import com.common.mail.service.MailService;

/**

 * @author Gaspar Rajoy - Flux IT

 **/
public class MailTask {
	
	@Autowired
	private MailService mailService;

	public MailService getMailService() {
		return mailService;
	}

	public void setMailService(MailService mailService) {
		this.mailService = mailService;
	}

	public void processMailQueue(){
		getMailService().processQueue();
	}

}

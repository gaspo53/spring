/*
 * Fluxit S.A
 * La Plata - Buenos Aires - Argentina
 * http://www.fluxit.com.ar
 * Author: Gaspar Rajoy
 * Date:  Mar 15, 2013 - 3:12:04 PM
 */
package com.common.mail.service;

/**

 * @author Gaspar Rajoy - Flux IT

 **/
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.mail.internet.MimeMessage;

import org.apache.velocity.app.VelocityEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.velocity.VelocityEngineUtils;

import com.common.dao.MailDAO;
import com.common.model.Mail;

@Service
@Transactional
public class MailServiceImpl implements MailService {

	
	@Autowired
	private MailDAO mailDAO;
	
	public MailDAO getMailDAO() {
		return mailDAO;
	}

	public void setMailDAO(MailDAO mailDAO) {
		this.mailDAO = mailDAO;
	}

	@Autowired
	private JavaMailSender javaMailSender;

	public void setMailSender(JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}

	@Autowired
	private VelocityEngine velocityEngine;

	public void setVelocityEngine(VelocityEngine velocityEngine) {
		this.velocityEngine = velocityEngine;
	}

	@Override
	public Mail update(Mail mail){
		return this.getMailDAO().update(mail);
	}
	
	@Override
	public void enqueue(Mail mail) {
		mail.setStatus(Mail.QUEUED);
		this.getMailDAO().save(mail);
	}

	@Override
	public void processQueue() {
		
		Iterator<Mail> mails = this.getMailDAO().getUnsent().iterator();
		
		while (mails.hasNext()){
			Mail mail = mails.next();
			this.send(mail);
		}
		
	}

	public void send(final Mail mail) {
		MimeMessagePreparator preparator = new MimeMessagePreparator() {
			public void prepare(MimeMessage mimeMessage) throws Exception {
				MimeMessageHelper message = new MimeMessageHelper(mimeMessage);
				message.setTo(mail.getToName());
				message.setFrom(mail.getFromName()); 
				message.setSubject(mail.getSubject());
														
				Map<String, Mail> model = new HashMap<String, Mail>();
				model.put("mail", mail);
				String text = VelocityEngineUtils.mergeTemplateIntoString(velocityEngine, mail.getTemplateName(), model);
				message.setText(text, true);
			}
		};
		this.javaMailSender.send(preparator);
		mail.setStatus(Mail.SENT);
		getMailDAO().update(mail);
		
	}

	@Override
	public void send(Long mailID) {
		Mail mail = this.getMailDAO().selectById(mailID);
		this.send(mail);
	}

	
	@Override
	public List<Mail> getUnsent(){
		
		List<Mail> mails = this.getMailDAO().getUnsent();
		
		return mails;
	}

	@Override
	public List<Mail> getAll(){
		
		List<Mail> mails = this.getMailDAO().getAll();
		
		return mails;
	}

	@Override
	public void delete(Mail mail) {
		this.getMailDAO().delete(mail);
		
	}

	@Override
	public void delete(Long id) {
		this.getMailDAO().delete(id);
		
	}

	@Override
	public Mail getMail(Long id) {
		
		return getMailDAO().selectById(id);
	}

	/* (non-Javadoc)
	 * @see com.common.mail.service.MailService#queueSize()
	 */
	@Override
	public int queueSize() {
		int size = this.getMailDAO().getUnsent().size();

		return size;
	}

	
}
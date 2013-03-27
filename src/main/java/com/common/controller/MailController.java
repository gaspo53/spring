/*
 * Fluxit S.A
 * La Plata - Buenos Aires - Argentina
 * http://www.fluxit.com.ar
 * Author: Gaspar Rajoy
 * Date:  Mar 21, 2013 - 4:46:49 PM
 */
package com.common.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.common.helpers.FlashMessageHelper;
import com.common.mail.service.MailService;
import com.common.model.Mail;

/**

 * @author Gaspar Rajoy - Flux IT

 **/

@RequestMapping("/mail")
@Controller
public class MailController {

	@Autowired
	private MailService mailService;


	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView list(HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes) {

		List<Mail> mails = this.getMailService().getUnsent();
		
		return new ModelAndView("mail.list","mails", mails);
	}

	@RequestMapping(value = "/new", method = RequestMethod.GET)
	public ModelAndView newMail(HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes) {

		return new ModelAndView("mail.new","mail",new Mail());
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView save(@Valid	 Mail mail, BindingResult result, 
							RedirectAttributes redirectAttributes, 
							HttpServletRequest request, HttpServletResponse response) {

		if (result.hasErrors()) {
			return this.newMail(request, response, redirectAttributes);
		}
		
		mail.setTemplateName("defaultMailTemplate.vm");
		/**
		 * Ahora lo hardcodeo por falta de modelo; pero se debería sacar el mail 
		 * del usuario logueado (salvo requerimientos de TecPlata).
		 **/
		mail.setFromName("Gaspar Rajoy <gaspo53@gmail.com>");
		
		if (mail.getId() != null) {
			this.getMailService().update(mail);
			FlashMessageHelper.success("mail.update.success", request);
		} else {
			this.getMailService().enqueue(mail);
			FlashMessageHelper.success("mail.add.success", request);
		}

		return this.list(request, response, redirectAttributes);
	}
	
	@RequestMapping(value = "/update/{id}")
	public ModelAndView update(@PathVariable
	String id, HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes) {

		Mail mail = getMailService().getMail((Long.parseLong(id)));
		
		return new ModelAndView("mail.new","mail",mail);
	}

	/** Delete a mail and return back to all list **/
	@RequestMapping(value = "/delete/{id}")
	public ModelAndView delete(@PathVariable
	String id, HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes) {

		getMailService().delete(Long.parseLong(id));
		FlashMessageHelper.success("mail.delete.success", request);
		
		return this.list(request, response, redirectAttributes);
	}

	
	public MailService getMailService() {
		return mailService;
	}

	public void setMailService(MailService mailService) {
		this.mailService = mailService;
	}

}

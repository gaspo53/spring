package com.common.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.common.model.Person;
import com.common.service.PersonService;

@RequestMapping("/superadmin")
@Controller

public class SuperAdminController {

	@Autowired
	private PersonService personService;
	
	static int id = 0;

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView save(Person person, BindingResult errors, HttpServletRequest request, HttpServletResponse response) {
		
			if ((Integer)person.getId() != null){
				personService.updatePerson(person);
				System.out.println("UPDATE");
			}else{
				personService.insertPerson(person);
				System.out.println("INSERT");
			}
			
			return this.displayAll(request);
	}

	@RequestMapping(value = "/new", method = RequestMethod.GET)
	public ModelAndView newUser(HttpServletRequest request) {

		return new ModelAndView("superadmin.new");
	}

	/**
	 * 
	 * Display all users
	 */
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView displayAll(HttpServletRequest request) {
		return new ModelAndView("superadmin.show", "persons",  personService.getAll());
	}

	/** Delete a user and return back to all list **/
	@RequestMapping(value = "/delete/{id}")
	public ModelAndView delete(@PathVariable String id) {
				
		personService.deletePerson(new String(id));

		return new ModelAndView("superadmin.show", "persons",  personService.getAll());
	}

	/** Update a user and return back to all list **/
	@RequestMapping(value = "/update/{id}")
	public ModelAndView update(@PathVariable String id) {

		return new ModelAndView("superadmin.show","person", personService.getPerson(id));

	}

	/**
	 * @return the personService
	 */
	public PersonService getPersonService() {
		return personService;
	}

	/**
	 * @param personService the personService to set
	 */
	public void setPersonService(PersonService personService) {
		this.personService = personService;
	}
	
	

}
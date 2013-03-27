package com.common.controller;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.common.helpers.FlashMessageHelper;
import com.common.model.Person;
import com.common.service.PersonService;

@RequestMapping("/person")
@Controller
public class PersonController {

	@Autowired
	private PersonService personService;

	static int id = 0;

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(false);

		// true passed to CustomDateEditor constructor means convert empty
		// String to null
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}

	@ExceptionHandler(ConstraintViolationException.class)
	public ModelAndView handleDuplicateError(Exception exception, HttpServletRequest request) {

		Person person_built = this.buildPersonFromRequest(request);
		FlashMessageHelper.error("user.add.mail.duplicated", request);
		return new ModelAndView("user.new", "person", person_built);

	}

	/**
	 * @param request
	 * @return Person
	 */
	private Person buildPersonFromRequest(HttpServletRequest request) {

		Person person = new Person();

		person.setId(Integer.parseInt(request.getParameter("id")));

		person.setCity(request.getParameter("city"));
		person.setLast_name(request.getParameter("last_name"));
		person.setName(request.getParameter("name"));
		person.setEmail(request.getParameter("email"));

		return person;
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView save(@Valid
	Person person, BindingResult result, RedirectAttributes attRedirectAttributes, HttpServletRequest request, HttpServletResponse response) {

		if (result.hasErrors()) {
			return this.newUser(request, person);
		}

		if ((Integer) person.getId() != 0) {
			personService.updatePerson(person);
			FlashMessageHelper.success("user.update.success", request);
		} else {
			personService.insertPerson(person);
			FlashMessageHelper.success("user.add.success", request);
		}

		return this.displayAll(request);
	}

	@RequestMapping(value = "/new", method = RequestMethod.GET)
	public ModelAndView newUser(HttpServletRequest request, Person person) {

		return new ModelAndView("user.new");
	}

	/**
	 * 
	 * Display all users
	 */
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView displayAll(HttpServletRequest request) {

		ModelAndView model = new ModelAndView("user.show", "persons", personService.getAll());

		return model;
	}

	/** Delete a user and return back to all list **/
	@RequestMapping(value = "/delete/{id}")
	public ModelAndView delete(@PathVariable
	String id, HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes) {

		personService.deletePerson(new String(id));
		FlashMessageHelper.success("user.delete.success", request);
		return new ModelAndView("user.show", "persons", personService.getAll());
	}

	/** Update a user and return back to all list **/
	@RequestMapping(value = "/update/{id}")
	public ModelAndView update(@PathVariable
	String id) {

		return new ModelAndView("user.new", "person", personService.getPerson(id));

	}

	/** Generate a PDF Report **/
	@RequestMapping(value = "/report/pdf")
	public ModelAndView generatePDFReport(HttpServletRequest request, HttpServletResponse response) {

		Map<String, Object> parameterMap = new HashMap<String, Object>();

		List<Person> personList = personService.getAll();

		JRDataSource person_list = new JRBeanCollectionDataSource(personList);

		parameterMap.put("person_list", person_list);

		return new ModelAndView("personReportList", parameterMap);

	}

	/** Generate a XLS Report **/
	@RequestMapping(value = "/report/xls")
	public ModelAndView generateXLSReport() {

		Map<String, Object> parameterMap = new HashMap<String, Object>();

		List<Person> personList = personService.getAll();

		JRDataSource person_list = new JRBeanCollectionDataSource(personList);

		parameterMap.put("person_list", person_list);

		return new ModelAndView("personReportList_xls", parameterMap);

	}

	/**
	 * @return the personService
	 */
	public PersonService getPersonService() {
		return personService;
	}

	/**
	 * @param personService
	 *            the personService to set
	 */
	public void setPersonService(PersonService personService) {
		this.personService = personService;
	}

}
/*
 * Fluxit S.A
 * La Plata - Buenos Aires - Argentina
 * http://www.fluxit.com.ar
 * Author: Gaspar Rajoy
 * Date:  Mar 26, 2013 - 1:37:06 PM
 */
package com.common.web.service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;

import com.common.model.Person;
import com.common.service.PersonService;

/**
 * 
 * @author Gaspar Rajoy - Flux IT
 **/
@WebService(endpointInterface = "com.common.web.service.PersonWebService", serviceName="personService")
public class PersonWebServiceBean implements PersonWebService {

	@Autowired
	private PersonService personService;

	/**
	 * @param personService
	 *            the personService to set
	 */
	public void setPersonService(PersonService personService) {
		this.personService = personService;
	}

	@Override
	@WebMethod
	public Person personDetail(@WebParam(name = "personId")
	String personId) {

		// if (Integer.parseInt(personId) < 10){

		Person person = personService.getPerson(personId);
		System.out.println(person);
		return person;
		// }
		// else{
		// throw new WebServiceException();
		// }
	}

}
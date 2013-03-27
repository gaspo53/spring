/*
 * Fluxit S.A
 * La Plata - Buenos Aires - Argentina
 * http://www.fluxit.com.ar
 * Author: gaspar
 * Date:  Mar 6, 2013 - 3:20:00 PM
 */
package com.common.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.common.dao.PersonDAO;
import com.common.exception.PersonException;
import com.common.model.Person;

@Service
@Transactional
public class PersonServiceDB implements PersonService {

	@Autowired
	private PersonDAO personDAO;

	/**
	 * @return the personDAO
	 */
	public PersonDAO getPersonDAO() {
		return personDAO;
	}

	/**
	 * @param personDAO the personDAO to set
	 */
	public void setPersonDAO(PersonDAO personDAO) {
		this.personDAO = personDAO;
	}

	public List<Person> getAll() throws PersonException {
		List<Person> persons = personDAO.getAllPerson();

		return persons;
	}

	@Override
	public long insertPerson(Person person) throws PersonException {
		personDAO.savePerson(person);
		return 0;
	}
	
	public void deletePerson(String id){
		try{
			personDAO.deletePerson(personDAO.selectPersonById(id));
		}
		catch (Exception e){
		}
	}

	/* (non-Javadoc)
	 * @see com.common.services.PersonService#getPerson(java.lang.String)
	 */

	public Person getPerson(String id) {
		return personDAO.selectPersonById(id);
	}

	/* (non-Javadoc)
	 * @see com.common.service.PersonService#updatePerson(com.common.model.Person)
	 */
	@Override
	public long updatePerson(Person person) throws PersonException {

		try{
			personDAO.updatePerson(person);
		}
		catch (Exception e){
		}
		return 0;
	}

}

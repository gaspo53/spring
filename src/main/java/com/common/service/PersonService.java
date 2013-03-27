/*
 * Fluxit S.A
 * La Plata - Buenos Aires - Argentina
 * http://www.fluxit.com.ar
 * Author: gaspar
 * Date:  Mar 6, 2013 - 3:17:31 PM
 */
package com.common.service;


import java.util.List;

import org.springframework.stereotype.Service;

import com.common.exception.PersonException;
import com.common.model.Person;

@Service
public interface PersonService {
	public List<Person> getAll() throws PersonException;
	public long insertPerson(Person person) throws PersonException;
	/**
	 * @param string
	 */
	 public void deletePerson(String string);
	/**
	 * @param name
	 * @return
	 */
	 
	public Person getPerson(String id);
	

	public long updatePerson(Person person) throws PersonException;
}
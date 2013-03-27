/*
 * Fluxit S.A
 * La Plata - Buenos Aires - Argentina
 * http://www.fluxit.com.ar
 * Author: gaspar
 * Date:  Mar 7, 2013 - 10:42:26 AM
 */
package com.common.dao;

import java.util.List;

import com.common.model.Person;

/**
 * @author gaspar
 *
 */
public interface PersonDAO {

	public void savePerson(Person person);
	public List<Person> getAllPerson();
	public Person selectPersonById(String personId);
	public void deletePerson(Person person);
	public void updatePerson(Person person);
	
}

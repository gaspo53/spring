/*
 * Fluxit S.A
 * La Plata - Buenos Aires - Argentina
 * http://www.fluxit.com.ar
 * Author: gaspar
 * Date:  Mar 7, 2013 - 11:26:20 AM
 */
package com.common.dao;


import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.hibernate.event.EventListeners;
import org.hibernate.impl.SessionFactoryImpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.common.model.Person;

@Repository("personService")
@Transactional
public class PersonDAOImpl implements PersonDAO{
	
	@Autowired
    private SessionFactory sessionFactory;

	/**
	 * @param sessionFactory the sessionFactory to set
	 */
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional(readOnly = false)
	public void savePerson(Person person) {
		this.sessionFactory.getCurrentSession().save(person);
	}

	@Transactional(readOnly = false)
	public void deletePerson(Person person) {
		this.sessionFactory.getCurrentSession().delete(person);
	}
	
	public List<Person> getAllPerson() {
		List<Person> persons =  this.sessionFactory.getCurrentSession().createCriteria(Person.class).list();
		
		return persons;
	}

	public Person selectPersonById(String personId) {
		return (Person) this.sessionFactory.getCurrentSession()
								.createCriteria(Person.class)
								.add(Restrictions.eq("id", Integer.parseInt(personId)))
								.uniqueResult();
	}

	/* (non-Javadoc)
	 * @see com.common.dao.PersonDAO#updatePerson(com.common.model.Person)
	 */
	@Override
	public void updatePerson(Person person) {
		this.sessionFactory.getCurrentSession().saveOrUpdate(person);
	
	}


	
}

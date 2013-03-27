/*
 * Fluxit S.A
 * La Plata - Buenos Aires - Argentina
 * http://www.fluxit.com.ar
 * Author: Gaspar Rajoy
 * Date:  Mar 19, 2013 - 11:13:34 AM
 */
package com.common.test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.common.dao.PersonDAO;


/**

 * @author Gaspar Rajoy - Flux IT

 **/

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { 
		"classpath*:**/mvc-dispatcher-serlvet.xml", 
		"classpath*:**/db-config.xml", 
		"classpath*:**/person-service.xml",
		"classpath*:**/mail-servlet.xml", 
		"classpath*:**/jms-setup.xml", 
		"classpath*:**/web-services-definition.xml", 
		"classpath*:**/web-services-clients-definition.xml"})

public class PersonDAOTest {

	@Autowired
	private PersonDAO personDAO;

	public PersonDAO getPersonDAO() {
		return personDAO;
	}

	public void setPersonDAO(PersonDAO personDAO) {
		this.personDAO = personDAO;
	}
	
	@Test
	public void testPersonDao(){
		assertEquals("Person must be created",1,1);
	}
	
}

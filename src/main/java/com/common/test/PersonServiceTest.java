/*
 * Fluxit S.A
 * La Plata - Buenos Aires - Argentina
 * http://www.fluxit.com.ar
 * Author: Gaspar Rajoy
 * Date:  Mar 19, 2013 - 10:32:06 AM
 */
package com.common.test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Repeat;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.common.model.Person;
import com.common.service.PersonService;


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

public class PersonServiceTest {

	@Autowired
	private PersonService personService;
	
	
	public PersonService getPersonService() {
		return personService;
	}

	public void setPersonService(PersonService personService) {
		this.personService = personService;
	}
	
	@Before
	public void initializeDatabase(){
		this.getPersonService().getAll();
	}

	@Test
	@Repeat(1)
	public void testPersonService(){
		long start = System.currentTimeMillis();
		
		int count_persons_before_insert = personService.getAll().size();
		
		Person person = new Person();
		
		person.setName("DANIEL GASPAR");
		person.setLast_name("RAJOY");
		
		personService.insertPerson(person);
		
		int count_persons_after_insert = personService.getAll().size();
		long total = System.currentTimeMillis()-start;
		
//		System.out.println(total);

		assertEquals("There must be one more person",count_persons_before_insert+1,count_persons_after_insert);
	}
}

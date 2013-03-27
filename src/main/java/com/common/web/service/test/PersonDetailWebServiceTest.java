/*
 * Fluxit S.A
 * La Plata - Buenos Aires - Argentina
 * http://www.fluxit.com.ar
 * Author: Gaspar Rajoy
 * Date:  Mar 26, 2013 - 3:17:34 PM
 */
package com.common.web.service.test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.common.model.Person;
import com.common.web.service.PersonWebService;

/**
 * 
 * @author Gaspar Rajoy - Flux IT
 **/

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:**/mvc-dispatcher-serlvet.xml", 
									"classpath*:**/db-config.xml", 
									"classpath*:**/person-service.xml",
									"classpath*:**/mail-servlet.xml", 
									"classpath*:**/jms-setup.xml", 
									"classpath*:**/web-services-definition.xml", 
									"classpath*:**/web-services-clients-definition.xml",

							})

public class PersonDetailWebServiceTest {

	@Autowired
	@Qualifier("personDetailServiceClient")
	private PersonWebService personDetailService;

	/**
	 * @param personDetailService
	 *            the personDetailService to set
	 */
	public void setPersonDetailService(PersonWebService personDetailService) {
		this.personDetailService = personDetailService;
	}

	@Test
	public void personDetailClientTest() {

		Person person = personDetailService.personDetail("10");
		
		System.out.println(person);
		
		
		assertEquals("Nombre de usuario","Gaspar",person.getName());
	}

}
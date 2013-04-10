/*
 * Fluxit S.A
 * La Plata - Buenos Aires - Argentina
 * http://www.fluxit.com.ar
 * Author: Gaspar Rajoy
 * Date:  Mar 26, 2013 - 3:17:34 PM
 */
package com.common.web.service.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.common.model.Person;
import com.common.web.service.PersonWebService;


/**
 * 
 * @author Gaspar Rajoy - Flux IT
 **/

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/web-services-clients-definition.xml"	})

@Service
@Qualifier("personDetailWebServiceTest")
public class PersonDetailWebServiceTest {

	@Autowired
	private PersonWebService personWebServiceClient;

	/**
	 * @param personWebService
	 *            the personDetailService to set
	 */
	public void setPersonWebServiceClient(PersonWebService personWebService) {
		this.personWebServiceClient = personWebService;
	}

	@Test
	public void personDetailClientTest() {

		Person person = personWebServiceClient.personDetail("1");
		
		assertEquals("Nombre de usuario","Gaspar",person.getName());
	}

}
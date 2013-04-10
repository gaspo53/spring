/*
 * Fluxit S.A
 * La Plata - Buenos Aires - Argentina
 * http://www.fluxit.com.ar
 * Author: Gaspar Rajoy
 * Date:  Mar 26, 2013 - 1:33:16 PM
 */
package com.common.web.service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import com.common.model.Person;

/**

 * @author Gaspar Rajoy - Flux IT

 **/
@WebService
public interface PersonWebService {
 
	@WebMethod
	public Person personDetail(@WebParam(name="personId") String personId);
}
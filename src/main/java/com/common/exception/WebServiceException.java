/*
 * Fluxit S.A
 * La Plata - Buenos Aires - Argentina
 * http://www.fluxit.com.ar
 * Author: gaspar
 * Date:  Mar 6, 2013 - 3:19:07 PM
 */
package com.common.exception;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.ws.WebFault;

@WebFault(name = "UnknownPersonFault")
@XmlAccessorType( XmlAccessType.FIELD )
public class WebServiceException extends RuntimeException {
	
	  protected String message;

	    public String getMessage() {
	        return message;
	    }

	    public void setMessage(String value) {
	        this.message = value;
	    }
}
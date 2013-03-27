/*
 * Fluxit S.A
 * La Plata - Buenos Aires - Argentina
 * http://www.fluxit.com.ar
 * Author: Gaspar Rajoy
 * Date:  Mar 14, 2013 - 12:11:47 PM
 */
package com.common.auth;

import org.springframework.security.core.SpringSecurityCoreVersion;

/**

 * @author Gaspar Rajoy - Flux IT

 **/
public class AuditFilterTestGaspar extends SpringSecurityCoreVersion {

	   public void doFilterHttp(AuditFilterTestGaspar chain){
	      chain.doFilterHttp(chain);
	   }

}
/*
 * Fluxit S.A
 * La Plata - Buenos Aires - Argentina
 * http://www.fluxit.com.ar
 * Author: Gaspar Rajoy
 * Date:  Mar 14, 2013 - 10:19:04 AM
 */
package com.common.auth;

import java.io.IOException;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

public class AuthenticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {
	  // getters and setters for injected services
		private static final Logger logger = Logger.getLogger(AuthenticationSuccessHandler.class);
	
	    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
	   // use authentication object to fetch the user object and update its timestamp
	    	Set<String> roles = AuthorityUtils
	                .authorityListToSet(SecurityContextHolder.getContext()
	                        .getAuthentication().getAuthorities());

	    	logger.warn(authentication.getName() + ": " + roles.toString());
	    	
	    	try {
				response.sendRedirect(request.getContextPath() + "/person");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	   }
	}
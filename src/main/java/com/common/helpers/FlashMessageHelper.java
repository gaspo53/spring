/*
 * Fluxit S.A
 * La Plata - Buenos Aires - Argentina
 * http://www.fluxit.com.ar
 * Author: Gaspar Rajoy
 * Date:  Mar 18, 2013 - 10:45:57 AM
 */
package com.common.helpers;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.annotation.Scope;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**

 * @author Gaspar Rajoy - Flux IT

 **/

@Scope(value = "session")
public class FlashMessageHelper {
    
	
	private static Map<String, String> messages = new HashMap<String, String>();
	
	
	public static Map<String,String> getMessages(){
		return messages;
	}
	
//	Flash message for redirect
	
	private static void addMessage(String message_code, String message_class, RedirectAttributes redirectAttributes){
		redirectAttributes.addFlashAttribute("message_code",message_code);
		redirectAttributes.addFlashAttribute("message_class",message_class);
	}
	
//	Flash message for request
	private static void addMessage(String message_code, String message_class, HttpServletRequest request){
//		getMessages().put(message_code, message_class);
		request.setAttribute("message_code",message_code);
		request.setAttribute("message_class",message_class);
	}

	public static void info(String message_code, RedirectAttributes redirectAttributes){
		addMessage(message_code, "alert-info", redirectAttributes);
	}
	
	public static void info(String message_code, HttpServletRequest request){
		addMessage(message_code, "alert-info", request);
	}
	
	public static void success(String message_code, RedirectAttributes redirectAttributes ){
		addMessage(message_code, "alert-success", redirectAttributes);
	}
	
	public static void success(String message_code, HttpServletRequest request){
		addMessage(message_code, "alert-success", request);
	}
	
	public static void warn(String message_code, RedirectAttributes redirectAttributes ){
		addMessage(message_code, "alert-warning", redirectAttributes);
	}
	
	public static void warn(String message_code, HttpServletRequest request){
		addMessage(message_code, "alert-warning", request);
	}
	
	public static void error(String message_code, RedirectAttributes redirectAttributes ){
		addMessage(message_code, "alert-error", redirectAttributes);
	}

	public static void error(String message_code, HttpServletRequest request){
		addMessage(message_code, "alert-error", request);
	}

	public static void reset(){
		
	}
}
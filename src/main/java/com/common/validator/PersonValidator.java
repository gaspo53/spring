/*
 * Fluxit S.A
 * La Plata - Buenos Aires - Argentina
 * http://www.fluxit.com.ar
 * Author: Gaspar Rajoy
 * Date:  Mar 20, 2013 - 2:28:00 PM
 */


package com.common.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.common.model.Person;
 
public class PersonValidator implements Validator{
	@Override
	public boolean supports(Class<?> clazz) {

		return Person.class.equals(clazz);
	}

	@Override
	public void validate(Object object, Errors errors) {
		
		Person person= (Person) object;
 
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "city", "field.required", "Required field");
		if ( ! errors.hasFieldErrors("email")) {
			if (person.getEmail().substring(2).isEmpty())
				errors.rejectValue("email", "not_blank", "Can't be free!");
		}		
	}
	
}

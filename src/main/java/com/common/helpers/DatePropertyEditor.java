/*
 * Fluxit S.A
 * La Plata - Buenos Aires - Argentina
 * http://www.fluxit.com.ar
 * Author: Gaspar Rajoy
 * Date:  Mar 20, 2013 - 12:15:29 PM
 */
package com.common.helpers;

/**

 * @author Gaspar Rajoy - Flux IT

 **/
import java.beans.PropertyEditorSupport;
import java.text.ParseException;
import java.util.Date;

import org.apache.commons.lang.time.DateUtils;

public class DatePropertyEditor extends PropertyEditorSupport {
	String[] formats = { "yyyy-MM-dd", "MM/dd/yyyy", "MM/dd/yy" };

	Date defaultDate = new Date(0L);

	public void setAsText(String textValue) {
		if (textValue == null) {
			setValue(defaultDate);
			return;
		}
		Date retDate = defaultDate;
		try {
			retDate = DateUtils.parseDate(textValue, formats);
		} catch (ParseException e) {
		}
		setValue(retDate);
	}

}
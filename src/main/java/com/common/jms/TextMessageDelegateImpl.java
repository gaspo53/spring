/*
 * Fluxit S.A
 * La Plata - Buenos Aires - Argentina
 * http://www.fluxit.com.ar
 * Author: grajoy
 * Date:  Mar 25, 2013 - 11:34:51 AM
 */
package com.common.jms;

import javax.jms.JMSException;
import javax.jms.TextMessage;

/**

 * @author grajoy - Flux IT

 **/
public class TextMessageDelegateImpl implements TextMessageDelegate {

	@Override
	public void receive(TextMessage message) throws JMSException {
		System.out.println(this.getClass().toString() + ": "+ message.getText());
		
	}
}
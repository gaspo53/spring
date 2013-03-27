/*
 * Fluxit S.A
 * La Plata - Buenos Aires - Argentina
 * http://www.fluxit.com.ar
 * Author: grajoy
 * Date:  Mar 25, 2013 - 11:21:31 AM
 */
package com.common.jms;

import javax.jms.JMSException;
import javax.jms.TextMessage;

/**

 * @author grajoy - Flux IT

 **/
public interface TextMessageDelegate {

    void receive(TextMessage message) throws JMSException;
}

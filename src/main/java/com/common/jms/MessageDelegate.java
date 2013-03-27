/*
 * Fluxit S.A
 * La Plata - Buenos Aires - Argentina
 * http://www.fluxit.com.ar
 * Author: grajoy
 * Date:  Mar 25, 2013 - 11:17:24 AM
 */
package com.common.jms;

import java.io.Serializable;
import java.util.Map;

/**

 * @author grajoy - Flux IT

 **/
public interface MessageDelegate {

	void handleMessage(String message);

    void handleMessage(Map message);

    void handleMessage(byte[] message);

    void handleMessage(Serializable message);

}

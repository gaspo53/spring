/*
 * Fluxit S.A
 * La Plata - Buenos Aires - Argentina
 * http://www.fluxit.com.ar
 * Author: grajoy
 * Date:  Mar 25, 2013 - 11:23:01 AM
 */
package com.common.jms;

import java.io.Serializable;
import java.util.Map;

/**

 * @author grajoy - Flux IT

 **/
public class DefaultMessageDelegate implements MessageDelegate {

	/* (non-Javadoc)
	 * @see com.common.jms.MessageDelegate#handleMessage(java.lang.String)
	 */
	@Override
	public void handleMessage(String message) {
		System.out.println("DEFAULT "+this.getClass().toString()+" "+message);
		
	}

	/* (non-Javadoc)
	 * @see com.common.jms.MessageDelegate#handleMessage(java.util.Map)
	 */
	@Override
	public void handleMessage(Map message) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see com.common.jms.MessageDelegate#handleMessage(byte[])
	 */
	@Override
	public void handleMessage(byte[] message) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see com.common.jms.MessageDelegate#handleMessage(java.io.Serializable)
	 */
	@Override
	public void handleMessage(Serializable message) {
		// TODO Auto-generated method stub
		
	}
    // implementation elided for clarity...
}
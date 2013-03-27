/*
 * Fluxit S.A
 * La Plata - Buenos Aires - Argentina
 * http://www.fluxit.com.ar
 * Author: Gaspar Rajoy
 * Date:  Mar 21, 2013 - 3:35:47 PM
 */
package com.common.dao;



import java.util.List;

import com.common.model.Mail;

/**

 * @author Gaspar Rajoy - Flux IT

 **/
public interface MailDAO {

		public Mail save(Mail mail);
		public int delete(Mail mail);
		public int delete(Long id);
		public Mail update(Mail mail);
		public Mail selectById(Long id);
		public List<Mail> getAll();
		public List<Mail> getUnsent();
		
		
}

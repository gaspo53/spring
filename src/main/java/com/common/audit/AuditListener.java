/*
 * Fluxit S.A
 * La Plata - Buenos Aires - Argentina
 * http://www.fluxit.com.ar
 * Author: grajoy
 * Date:  Mar 25, 2013 - 4:39:31 PM
 */
package com.common.audit;

/**

 * @author grajoy - Flux IT

 **/
import java.io.Serializable;
import java.util.Date;

import org.hibernate.HibernateException;
import org.hibernate.Transaction;
import org.hibernate.event.PostDeleteEvent;
import org.hibernate.event.PostInsertEvent;
import org.hibernate.event.PostUpdateEvent;
import org.hibernate.event.SaveOrUpdateEvent;
import org.hibernate.event.def.DefaultSaveOrUpdateEventListener;
import org.hibernate.type.Type;
import org.springframework.beans.factory.annotation.Autowired;

public class AuditListener extends DefaultSaveOrUpdateEventListener {

	@Autowired
	private LogEntryDAO logEntryDAO;
	
	
	public LogEntryDAO getLogEntryDao() {
		return logEntryDAO;
	}

	public void setLogEntryDao(LogEntryDAO logEntryDao) {
		this.logEntryDAO = logEntryDao;
	}

	public void onDelete(Object entity, Serializable id, Object[] state, String[] propertyNames, Type[] types) {
		System.out.println("onDelete");
	}

	public boolean onFlushDirty(Object entity, Serializable id, Object[] currentState, Object[] previousState, String[] propertyNames, Type[] types) {
		System.out.println("ENTRO A ONFLUSHDIRTY");

		if (entity instanceof Auditable) {
			for (int i = 0; i < propertyNames.length; i++) {
				if ("lastUpdateTimestamp".equals(propertyNames[i])) {
					currentState[i] = new Date();
					return true;
				}
			}
		}
		return false;
	}

	public boolean onSave(Object entity, Serializable id, Object[] state, String[] propertyNames, Type[] types) {
		System.out.println("ENTRO A ONSAVE");
		if (entity instanceof Auditable) {
			for (int i = 0; i < propertyNames.length; i++) {
				if ("createTimestamp".equals(propertyNames[i])) {
					state[i] = new Date();
					return true;
				}
			}
		}
		return false;
	}

	public void afterTransactionCompletion(Transaction tx) {
		if (tx.wasCommitted()) {

		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.hibernate.event.SaveOrUpdateEventListener#onSaveOrUpdate(org.hibernate
	 * .event.SaveOrUpdateEvent)
	 */
	@Override
	public void onSaveOrUpdate(SaveOrUpdateEvent event) throws HibernateException {
		System.out.println("ENTRO A SAVE UPDATE");
		LogEntry logEntry = new LogEntry();
		
		logEntry.setDescription("TEST LOG");
		logEntry.setEntity(event.getEntityName());
		logEntry.setUser("gaspar");
		logEntryDAO.save(logEntry);
		

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.hibernate.event.PostDeleteEventListener#onPostDelete(org.hibernate
	 * .event.PostDeleteEvent)
	 */
	public void onPostDelete(PostDeleteEvent event) {
		System.out.println("POST DELETE");
		LogEntry logEntry = new LogEntry();
		logEntry.setDescription("TEST LOG");
		logEntry.setEntity(event.getEntity().getClass().toString());
		logEntry.setUser("gaspar");
		logEntryDAO.save(logEntry);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.hibernate.event.PostUpdateEventListener#onPostUpdate(org.hibernate
	 * .event.PostUpdateEvent)
	 */
	public void onPostUpdate(PostUpdateEvent event) {
		System.out.println("POST UPDATE");

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.hibernate.event.PostInsertEventListener#onPostInsert(org.hibernate
	 * .event.PostInsertEvent)
	 */
	public void onPostInsert(PostInsertEvent event) {
		// TODO Auto-generated method stub
		System.out.println("POST INSERT");
	}

}
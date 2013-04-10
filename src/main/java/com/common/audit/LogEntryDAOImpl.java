/*
 * Fluxit S.A
 * La Plata - Buenos Aires - Argentina
 * http://www.fluxit.com.ar
 * Author: grajoy
 * Date:  Mar 26, 2013 - 9:42:21 AM
 */
package com.common.audit;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

/**

 * @author grajoy - Flux IT

 **/

@Transactional
public class LogEntryDAOImpl extends GenericDAOImpl<LogEntry, Long> implements LogEntryDAO {

	/**
	 * @param sessionFactory the sessionFactory to set
	 */
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public boolean save(LogEntry logEntry){
		System.out.println("SAVE DAOImpl");
		
		System.out.println(sessionFactory);
		sessionFactory.getCurrentSession().save(logEntry);
		
		return true;
		
//		return super.save(logEntry);
	}
	

	/* (non-Javadoc)
	 * @see com.common.audit.LogEntryDAO#findByUsername(java.lang.String)
	 */
	@Override
	public LogEntry findByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.common.audit.LogEntryDAO#findByOperationType(java.lang.String)
	 */
	@Override
	public LogEntry findByOperationType(String operationType) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.common.audit.LogEntryDAO#remove(java.lang.Long)
	 */
	@Override
	public boolean remove(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see com.common.audit.LogEntryDAO#remove(com.common.audit.LogEntry)
	 */
	@Override
	public boolean remove(LogEntry logEntry) {
		// TODO Auto-generated method stub
		return false;
	}

}
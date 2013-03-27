/*
 * Fluxit S.A
 * La Plata - Buenos Aires - Argentina
 * http://www.fluxit.com.ar
 * Author: grajoy
 * Date:  Mar 26, 2013 - 9:33:11 AM
 */
package com.common.audit;

/**

 * @author grajoy - Flux IT

 **/
public interface LogEntryDAO extends GenericDAO<LogEntry, Long> {

	public LogEntry findByUsername(String username);
	public LogEntry findByOperationType(String operationType);
	
	public boolean save(LogEntry logEntry);
	public boolean remove(LogEntry logEntry);
	public boolean remove(Long id);
	
	
}
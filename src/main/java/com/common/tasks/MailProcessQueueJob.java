/*
 * Fluxit S.A
 * La Plata - Buenos Aires - Argentina
 * http://www.fluxit.com.ar
 * Author: Gaspar Rajoy
 * Date:  Mar 22, 2013 - 12:39:07 PM
 */
package com.common.tasks;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

/**

 * @author Gaspar Rajoy - Flux IT

 **/
public class MailProcessQueueJob extends QuartzJobBean{

	
	private MailTask mailTask;

	public MailTask getMailTask() {
		return mailTask;
	}

	public void setMailTask(MailTask mailTask) {
		this.mailTask = mailTask;
	}

	@Override
	protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
		getMailTask().processMailQueue();
	}

}

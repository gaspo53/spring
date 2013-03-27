/*
 * Fluxit S.A
 * La Plata - Buenos Aires - Argentina
 * http://www.fluxit.com.ar
 * Author: Gaspar Rajoy
 * Date:  Mar 21, 2013 - 3:11:27 PM
 */
package com.common.model;

import java.util.Date;
import java.util.Map;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author Gaspar Rajoy - Flux IT
 **/

@Entity
public class Mail {

	
	public static final int QUEUED= -1;
	public static final int NOT_SENT = 0;
	public static final int SENT = 1;
	
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String from_name;

	private String to_name;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date created_at;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date updated_at;
	
	/**
	 * @return the updated_at
	 */
	public Date getUpdated_at() {
		return updated_at;
	}

	/**
	 * @param updated_at the updated_at to set
	 */
	public void setUpdated_at(Date updated_at) {
		this.updated_at = updated_at;
	}

	private String subject;

	private String body;
	
	/**
	 * 
	 * Es necesario hacer un State???	
	 */
	private int status;
	
	private String templateName;
	
	@ElementCollection
	private Map<String, String> attributes;
	

	
	public Mail(){
	}
	
	public Mail(String templateName){
		this.setTemplateName(templateName);
	}
	
	
	@PrePersist
	protected void onCreate() {
		updated_at = created_at = new Date();
	}
	
	@PreUpdate
	protected void onUpdate() {
	  updated_at = new Date();
	}
	
	
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the from
	 */
	public String getFromName() {
		return from_name;
	}

	/**
	 * @param from
	 *            the from to set
	 */
	public void setFromName(String from) {
		this.from_name = from;
	}

	/**
	 * @return the to
	 */
	public String getToName() {
		return to_name;
	}

	/**
	 * @param to
	 *            the to to set
	 */
	public void setToName(String to) {
		this.to_name = to;
	}

	/**
	 * @return the date
	 */
	public Date getCreatedAt() {
		return created_at;
	}

	/**
	 * @param date
	 *            the date to set
	 */
	public void setCreatedAt(Date date) {
		this.created_at = date;
	}

	/**
	 * @return the subject
	 */
	public String getSubject() {
		return subject;
	}

	/**
	 * @param subject
	 *            the subject to set
	 */
	public void setSubject(String subject) {
		this.subject = subject;
	}

	/**
	 * @return the body
	 */
	public String getBody() {
		return body;
	}

	/**
	 * @param body
	 *            the body to set
	 */
	public void setBody(String body) {
		this.body = body;
	}

	/**
	 * @return the attributes
	 */
	public Map<String, String> getAttributes() {
		return attributes;
	}

	/**
	 * @param attributes
	 *            the attributes to set
	 */
	public void setAttributes(Map<String, String> attributes) {
		this.attributes = attributes;
	}
	
	public void addAttribute(Map<String, String> attribute){
		this.getAttributes().putAll(attribute);
	}

	public void addAttribute(String key, String value){
		this.getAttributes().put(key,value);
	}
	
	/**
	 * @return the status
	 */
	public int getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(int status) {
		this.status = status;
	}

	public String getTemplateName() {
		return templateName;
	}

	public void setTemplateName(String templateName) {
		this.templateName = templateName;
	}


}

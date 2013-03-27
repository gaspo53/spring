package com.common.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

import com.common.audit.Auditable;

@Entity
@Table(uniqueConstraints={@UniqueConstraint(columnNames={"email"})})
public class Person implements Auditable{
	@NotBlank(message="{user.add.name.blank}")
	@Size(min=3,message="{user.add.name.size}")
	private String name;
	
	@NotBlank(message="{user.add.last_name.blank}")
	private String last_name;

	private String city;
	
	@Column(unique=true) 
	private String email;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	public Person(String name, String city) {
		this.name = name;
		this.city = city;
	}

	public Person(int id, String name, String city) {
		this.name = name;
		this.city = city;
		this.id = id;
	}

	public Person() {
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the last_name
	 */
	public String getLast_name() {
		return last_name;
	}

	/**
	 * @param last_name
	 *            the last_name to set
	 */
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

}

/**
 * 
 */
package org.lenzi.model;

import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author sal
 *
 */
@XmlRootElement(name = "person")
@XmlAccessorType(XmlAccessType.PUBLIC_MEMBER)
public class Person {

	@XmlElement(name = "id", required = true)
	private int id = 0;
	
	@XmlElement(name = "firstName", required = true)
	private String firstName = null;
	
	@XmlElement(name = "middleName" , required = false)
	private String middleName = null;
	
	@XmlElement(name = "lastName", required = true)
	private String lastName = null;
	
	/**
	 * 
	 */
	public Person() {
		
	}

	/**
	 * 
	 * @param id
	 * @param firstName
	 * @param middleName
	 * @param lastName
	 */
	public Person(int id, String firstName, String middleName, String lastName) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the middleName
	 */
	public String getMiddleName() {
		return middleName;
	}

	/**
	 * @param middleName the middleName to set
	 */
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Person [id=" + id + ", firstName=" + firstName
				+ ", middleName=" + middleName + ", lastName=" + lastName + "]";
	}

}

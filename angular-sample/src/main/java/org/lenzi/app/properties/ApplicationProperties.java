package org.lenzi.app.properties;

/**
 * Properties interface
 * 
 * @author sal
 *
 */
public interface ApplicationProperties {

	/**
	 * Fetch a property
	 *  
	 * @param name The name of the property
	 * @return The value of the property if defined.
	 */
	public String getProperty(String name);
	
}

/**
 * 
 */
package org.lenzi.service.jersey;

import java.util.Set;

import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author sal
 *
 * Jersey application configuration.
 */
public class MyApplication extends ResourceConfig {

	private Logger logger = LoggerFactory.getLogger(MyApplication.class);
	
	/**
	 * 
	 */
	public MyApplication() {
		registerClass(SampleService.class);
		registerClass(JacksonFeature.class);
	}
	
	/**
	 * Register as class with Jersey
	 * 
	 * @param componentClass
	 */
	private void registerClass(Class<?> componentClass){
		logger.info("Registering resource " + componentClass.getName() + " with Jersey.");
		register(componentClass);
	}

	/**
	 * @param classes
	 */
	public MyApplication(Set<Class<?>> classes) {
		super(classes);
	}

	/**
	 * @param classes
	 */
	public MyApplication(Class<?>... classes) {
		super(classes);
	}

	/**
	 * @param original
	 */
	public MyApplication(ResourceConfig original) {
		super(original);
	}

}

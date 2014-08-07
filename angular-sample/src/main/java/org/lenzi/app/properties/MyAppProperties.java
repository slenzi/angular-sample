package org.lenzi.app.properties;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

/**
 * Global application properties for our sample application
 *
 * @see org.lenzi.app.config.PropertyConfig
 * @author sal
 */
@Component(value="SampleAppProperties")
@Scope("singleton")
public class MyAppProperties implements ApplicationProperties {

	@Inject
	Environment env;
	
	@Value( "${app.title}" )
	private String appTitle = null;
	
	@Value( "${app.version}" )
	private String appVersion = null;
	
	@Value( "${csv.data.path}" )
	private String csvDataPath = null;

	/**
	 * @return the appTitle
	 */
	public String getAppTitle() {
		return appTitle;
	}

	/**
	 * @return the appVersion
	 */
	public String getAppVersion() {
		return appVersion;
	}

	/**
	 * @return the csvDataPath
	 */
	public String getCsvDataPath() {
		return csvDataPath;
	}

	@Override
	public String getProperty(String name) {
		return env.getProperty(name);
	}

}

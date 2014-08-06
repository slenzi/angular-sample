package org.lenzi.app.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Global application properties
 *
 * @see org.lenzi.app.config.PropertyConfig
 * @author sal
 */
@Component
@Scope("singleton")
public class AppProperties {

	@Value( "${app.title}" )
	private String appTitle = null;
	
	@Value( "${app.version}" )
	private String appVersion = null;

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
	
}

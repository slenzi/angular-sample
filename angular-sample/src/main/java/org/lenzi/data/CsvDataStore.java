/**
 * 
 */
package org.lenzi.data;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.lenzi.app.properties.ApplicationProperties;
import org.lenzi.app.properties.MyAppProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Repository;

/**
 * @author sal
 *
 */
@Repository("CsvDataStore")
@Scope(value = "singleton")
public class CsvDataStore {

	private Logger logger = LoggerFactory.getLogger(CsvDataStore.class);
	
    @Autowired
    @Qualifier("SampleAppProperties")
    private ApplicationProperties appProps;
    
    @Autowired
    private ApplicationContext appContext;    
	
	/**
	 * 
	 */
	public CsvDataStore() {
		
	}
	
	/**
	 * Load CVS data from the classpath
	 */
	@PostConstruct
	public void init(){
		
		logger.debug(CsvDataStore.class + " init method called.");
		
		logger.debug("Loading data from " + appProps.getProperty("csv.data.path"));
		
		Resource csvResource = appContext.getResource("classpath:" + appProps.getProperty("csv.data.path"));
		
		logger.debug("Have CSV resource?: " + ((csvResource != null) ? true : false));
		
	}
	
	/**
	 * 
	 */
	@PreDestroy
	public void cleanup(){
		
		logger.debug(CsvDataStore.class + " cleanup method called.");
		
	}

}

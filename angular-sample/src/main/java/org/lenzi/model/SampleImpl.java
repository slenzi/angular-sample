/**
 * 
 */
package org.lenzi.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.lenzi.app.properties.AppProperties;
import org.lenzi.service.jersey.SampleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author sal
 *
 */
@Component
public class SampleImpl implements Sample {

	private Logger logger = LoggerFactory.getLogger(SampleImpl.class);
	
	private HashMap<String, String > mySamples = new HashMap<String, String>(){{
        put("1","Sample 1");
        put("2","Sample 2");
        put("3","Sample 3");
        put("4","Sample 4");
        put("5","Sample 5");
    }};
    
    @Autowired
    private AppProperties appProps;
	
	/**
	 * 
	 */
	public SampleImpl() {
		logger.debug(SampleImpl.class.getName() + " instance created");
	}

	@Override
	public String hello() {
		return "Hello Jersey + Spring (v" + appProps.getAppVersion() + ")";
	}

	@Override
	public String getSample(String id) {
		if(mySamples.containsKey(id)){
			return mySamples.get(id);
		}
		return "Unknown sample.";
	}

	@Override
	public List<String> getSamples() {
		return new ArrayList<String>(mySamples.values());
	}
	
}

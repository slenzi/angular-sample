/**
 * 
 */
package org.lenzi.service.jersey;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.lenzi.data.CsvDataLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author sal
 *
 * Spring managed JAX-RS resource.
 */
@Component
@Path("/sample")
public class SampleService {

	private Logger logger = LoggerFactory.getLogger(SampleService.class);
	
	@Autowired
	CsvDataLoader dataLoader = null;	
	
	public SampleService() {
		super();
		logger.debug(SampleService.class.getName() + " instance created.");
	}
	
	/**
	 * @return Number of rows in our data
	 */
	@GET
	@Path("/rowcount")
	@Produces(MediaType.TEXT_PLAIN)
	public String getRowCount(){
		return String.valueOf(dataLoader.getData().rowCount());
	}
	
	/**
	 * Fetch keyset from our data
	 * 
	 * @return Set of keys in JSON format
	 */
	@GET
	@Path("/keyset")
	@Produces(MediaType.APPLICATION_JSON)
	public Set<String> getSampleJson() {
		return dataLoader.getData().keySet();
	}		
	
	/**
	 * Fetch all rows of data were "Common Name" starts with the specified letter.
	 * 
	 * @param letter
	 * @return
	 */
	@GET
	@Path("/alpha/{letter}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<HashMap<String, String>> getSample(@PathParam("letter") String letter) {
		String regEx = "^\\s*" + letter + ".*$";
		return dataLoader.getData().fetch("Common Name", regEx);
	}

}

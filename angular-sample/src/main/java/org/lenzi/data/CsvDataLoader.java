/**
 * 
 */
package org.lenzi.data;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.apache.commons.io.IOUtils;
import org.lenzi.app.properties.ApplicationProperties;
import org.lenzi.model.DataTable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Repository;

import au.com.bytecode.opencsv.CSVReader;

/**
 * @author sal
 *
 */
@Repository("CsvDataStore")
@Scope(value = "singleton")
public class CsvDataLoader {

	private Logger logger = LoggerFactory.getLogger(CsvDataLoader.class);
	
    @Autowired
    @Qualifier("SampleAppProperties")
    private ApplicationProperties appProps;
    
    @Autowired
    private ApplicationContext appContext;
    
    private List<HashMap<String,String>> csvMapData = null;
    
    private DataTable dataTable = null;
    
	/**
	 * 
	 */
	public CsvDataLoader() {
		
	}
	
	/**
	 * Fetch all CSV data as a DataTable model
	 * 
	 * @return
	 */
	public DataTable getData(){
		return dataTable;
	}
	
	/**
	 * Load CVS data from the classpath.
	 */
	@PostConstruct
	public void init(){
		
		logger.debug(CsvDataLoader.class + " init method called.");
		
		logger.debug("Loading data from " + appProps.getProperty("csv.data.path"));
		
		Resource csvResource = appContext.getResource("classpath:" + appProps.getProperty("csv.data.path"));
		
		boolean haveCsvResource = ((csvResource != null) ? true : false);
		logger.debug("Have CSV resource?: " + haveCsvResource);
		
		if(haveCsvResource){
			loadCsv(csvResource);
			if(csvMapData != null){
				logger.debug("Loaded " + csvMapData.size() + " rows of data from " + appProps.getProperty("csv.data.path"));
			}
		}
		
	}

	/**
	 * Loads the CSV data into our DataTable model.
	 * 
	 * @param csvResource The CSV resource.
	 */
	private void loadCsv(Resource csvResource){
		
		CSVReader csvReader = null;
		InputStream inStream = null;
		BufferedReader bufReader = null;
		String[] headerData = null, data = null;
		HashMap<String,String> rowData = null;
		int valueIndex = 0;
		
		try {
			inStream = csvResource.getInputStream();
			bufReader = new BufferedReader(new InputStreamReader(inStream));
			csvReader = new CSVReader(bufReader);
			csvMapData = new ArrayList<HashMap<String,String>>();
			headerData = csvReader.readNext();
			while((data = csvReader.readNext()) != null){
				rowData = new HashMap<String,String>();
				for(valueIndex = 0; valueIndex < headerData.length; valueIndex++){
					rowData.put(headerData[valueIndex], data[valueIndex]);
				}
				csvMapData.add(rowData);
			}
		} catch (IOException e) {
			logger.error("Error reading resource " + csvResource.getFilename());
		}finally{
			IOUtils.closeQuietly(csvReader);
			IOUtils.closeQuietly(bufReader);
			IOUtils.closeQuietly(inStream);
		}
		dataTable = new DataTable(csvMapData);
		
	}
	
	/**
	 * 
	 */
	@PreDestroy
	public void cleanup(){
		
		logger.debug(CsvDataLoader.class + " cleanup method called.");
		
	}

}

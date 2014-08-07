package org.lenzi.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Component;

/**
 * 
 * @author sal
 *
 */
@Component
public class DataTable {

	private List<HashMap<String,String>> data = null;
	
	public DataTable() {
		data = new ArrayList<HashMap<String,String>>();
	}
	
	public DataTable(List<HashMap<String,String>> data) {
		this.data = data;
	}
	
	/**
	 * Fetch number of rows in our table.
	 * 
	 * @return
	 */
	public int rowCount(){
		return ((data != null) ? data.size() : 0);
	}
	
	/**
	 * Fetch all rows with the matching value for specified key
	 * 
	 * e.g. fetch("Common Name","^\\s*U.*$") will fetch all rows where the "Common Name"
	 * value starts with the letter 'U', allowing for white space at the beginning.
	 * 
	 * @param key The table key
	 * @param regEx regular expression used to match against all values for the key.
	 * @return
	 */
	public List<HashMap<String,String>> fetch(String key, String regEx){
		if(data == null){
			return null;
		}
		List<HashMap<String,String>> matchingRows = new ArrayList<HashMap<String,String>>();
		for(HashMap<String,String> row : data){
			if(row.containsKey(key) && row.get(key) != null && row.get(key).matches(regEx)){
				matchingRows.add(row);
			}
		}
		return matchingRows;
	}
	
	/**
	 * Fetch unique keyset from all rows.
	 * 
	 * @return
	 */
	public Set<String> keySet() {
		if(data == null){
			return null;
		}
		Set<String> keys = new HashSet<String>();
		for(HashMap<String,String> row : data){
			keys.addAll(row.keySet());
		}
		return keys;
	}

}

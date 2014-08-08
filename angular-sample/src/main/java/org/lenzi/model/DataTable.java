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
	 * Fetch all rows with the matching value for specified key.
	 * 
	 * e.g. fetch("Common Name","^\\s*U.*$")
	 * 
	 * This will fetch all rows where the "Common Name" value starts with the letter 'U', allowing for
	 * white space at the beginning.
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
			if(match(row,key,regEx)){
				matchingRows.add(row);
			}
		}
		return matchingRows;
	}
	
	/**
	 * Fetch all rows with matching values for all keys. The key array must be the
	 * same length as the regEx array.
	 * 
	 * e.g. fetch( new String[]{"Common Name","Capital"}, new String[]{"^\\s*U.*$","^.*on\\s*$"} )
	 * 
	 * This will fetch all rows where the "Common Name" starts with the letter 'U' and the 'Capital' name
	 * ends in 'on', allowing for white space. i.e. United States & Washington, plus United Kingdom & London.
	 * 
	 * @param keys
	 * @param regEx
	 * @return
	 */
	public List<HashMap<String,String>> fetch(String[] keys, String[] regExs){
		if(data == null){
			return null;
		}
		List<HashMap<String,String>> matchingRows = new ArrayList<HashMap<String,String>>();
		for(HashMap<String,String> row : data){
			if(match(row,keys,regExs)){
				matchingRows.add(row);
			}
		}
		return matchingRows;		
	}
	
	/**
	 * Check if the value in row[key] matches against the regular expression.
	 * 
	 * @param row
	 * @param key
	 * @param regEx
	 * @return
	 */
	private boolean match(HashMap<String,String> row, String key, String regEx){
		if(row.containsKey(key) && row.get(key) != null && row.get(key).matches(regEx)){
			return true;
		}
		return false;
	}
	
	/**
	 * For all keys k in keys[k0,k1,...kN], check if row[k] matches against regular expression e in regExs[e0,e1,...eN]
	 * 
	 * @param row
	 * @param keys
	 * @param regExs
	 * @return
	 */
	private boolean match(HashMap<String,String> row, String[] keys, String[] regExs){
		for(int keyIndex = 0; keyIndex < keys.length; keyIndex++){
			if(!match(row,keys[keyIndex],regExs[keyIndex])){
				return false;
			}
		}
		return true;
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

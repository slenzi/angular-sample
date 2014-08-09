/**
 * 
 */
package org.lenzi.model;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import org.springframework.stereotype.Component;

/**
 * @author sal
 *
 */
@Component
public class PersonDb {

	private Hashtable<Integer,Person> people = new Hashtable<Integer,Person>(){{
		put(1,new Person(1,"Bugs","E","Bunny"));
		put(2,new Person(2,"Elmer","J","Fudd"));
		put(3,new Person(3,"Speedy","H","Gonzales"));
		put(4,new Person(4,"Pepe","Le","Pew"));
	}};
	
	/**
	 * 
	 */
	public PersonDb() {
		
	}

	/**
	 * Get a person.
	 * 
	 * @param id
	 * @return
	 */
	public Person getPerson(int id){
		return people.get(id);
	}
	
	/**
	 * Get all people
	 * 
	 * @return
	 */
	public List<Person> getAllPeople(){
		return new ArrayList<Person>(people.values());
	}
	
	/**
	 * Add/Save a person.
	 * 
	 * @param p
	 */
	public void addPerson(Person p){
		people.put(p.getId(), p);
	}
	
	/**
	 * Removes the person.
	 * 
	 * @param id The id of the person.
	 * @return The person that was removed if they existed in the db, otherwise null.
	 */
	public Person removePerson(int id){
		Person p = getPerson(id);
		people.remove(id);
		return p;
	}
	
}

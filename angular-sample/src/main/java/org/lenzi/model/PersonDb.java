/**
 * 
 */
package org.lenzi.model;

import java.util.Hashtable;

/**
 * @author sal
 *
 */
public class PersonDb {

	private Hashtable<Integer,Person> people = new Hashtable<Integer,Person>(){{
		put(1,new Person(1,"Bugs","E","Bunny"));
		put(2,new Person(1,"Elmer","J","Fudd"));
		put(3,new Person(1,"Speedy","H","Gonzales"));
		put(4,new Person(1,"Pepe","Le","Pew"));
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
	 * Add/Save a person.
	 * 
	 * @param p
	 */
	public void addPerson(Person p){
		people.put(p.getId(), p);
	}
	
	/**
	 * Delete/Remove a person.
	 * 
	 * @param id
	 */
	public void deletePerson(int id){
		people.remove(id);
	}
	
}

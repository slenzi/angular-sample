/**
 * 
 */
package org.lenzi.service.jersey;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.lenzi.model.Person;
import org.lenzi.model.PersonDb;
import org.lenzi.service.exception.ServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author sal
 *
 * Example C.R.U.D. service.
 */
@Component
@Path("/person")
public class PersonService {

	private Logger logger = LoggerFactory.getLogger(PersonService.class);
	
	@Autowired
	PersonDb personDb = null;
	
	/**
	 * 
	 */
	public PersonService() {
		super();
		logger.debug(PersonService.class.getName() + " instance created.");
	}
	
	/**
	 * Fetch person by id.
	 * 
	 * @param letter
	 * @return
	 */
	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Person getPersonById(@PathParam("id") int id) {
		return personDb.getPerson(id);
	}
	
	/**
	 * Fetch all people.
	 * 
	 * @return
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Person> getAllPeople() {
		return personDb.getAllPeople();
	}
	
	/**
	 * Add new person.
	 * 
	 * Implement POST by directly consuming JAXB resource.
	 * 
	 * @param p
	 * @return
	 * @throws ServiceException
	 */
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addPerson(Person p) throws ServiceException {
		
		logger.debug(PersonService.class.getName() + " addPerson called");
		
		if(p == null){
			logger.debug("Person object is null.");
		}else{
			logger.debug(p.toString());
		}
		
		if(p.getId() == 0 || p.getFirstName() == null || p.getLastName() == null){
			throw new ServiceException("Mising required data for creating new person.");
		}
		personDb.addPerson(p);
		return Response.ok(p, MediaType.APPLICATION_JSON).build();	
	}
	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updatePerson(Person p) throws ServiceException {
		
		logger.debug(PersonService.class.getName() + " updatePerson called");

		return Response.ok("{ \"error\" : \"Not implemeneted\" }", MediaType.APPLICATION_JSON).build();	
	}	

	/**
	 * Remove a person.
	 * 
	 * @param id
	 * @return
	 * @throws ServiceException 
	 */
	@DELETE
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deletePerson(@PathParam("id") int id) throws ServiceException {
		
		logger.debug(PersonService.class.getName() + " deletePerson called");
		
		Person p = personDb.removePerson(id);
		if(p == null){
			throw new ServiceException("No person exists with id " + id);
		}
		return Response.ok(p, MediaType.APPLICATION_JSON).build();
	}

}




/*
@Produces(MediaType.TEXT_HTML)
@QueryParam("firstName") String firstName
@FormParam("firstName") String firstName
method(@Context HttpServletResponse servletResponse)
servletResponse.sendRedirect("../create_todo.html");
return Response.status(Response.Status.BAD_REQUEST).build();
*/

/**
* Add new person.
* 
* Implements POST using @FormParam fields
* 
* @param id
* @param firstName
* @param middleName
* @param lastName
* @param servletResponse
* @return the newly created person.
* @throws WebApplicationException
*/
/*
@POST
@Path("/addByForm")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
public Response addPersonByFormParam(
	@FormParam("id") Integer id,
	@FormParam("firstName") String firstName,
	@FormParam("middleName") String middleName,
	@FormParam("lastName") String lastName,
	@Context HttpServletResponse servletResponse) throws ServiceException {
	
	logger.debug(PersonService.class.getName() + " addPersonByFormParam called");
	if(id == null || firstName == null || lastName == null){
		throw new ServiceException("Missing required request form paramaters to create new person.");
	}
	Person p = new Person(id.intValue(),firstName,middleName,lastName);
	personDb.addPerson(p);
	return Response.ok(p, MediaType.APPLICATION_JSON).build();
}
*/

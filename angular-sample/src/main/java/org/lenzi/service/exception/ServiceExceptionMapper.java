/**
 * 
 */
package org.lenzi.service.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * @author sal
 *
 * Maps a ServiceException to a javax.ws.rs.core.Response which can then be uses to send a valid HTTP
 * error code back to the calling client.
 */
@Provider
public class ServiceExceptionMapper implements ExceptionMapper<ServiceException> {

	/**
	 * 
	 */
	public ServiceExceptionMapper() {
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see javax.ws.rs.ext.ExceptionMapper#toResponse(java.lang.Throwable)
	 */
	@Override
	public Response toResponse(ServiceException exception) {
		
		return Response.status(Status.BAD_REQUEST).entity(exception.getMessage()).build();
		
	}

}

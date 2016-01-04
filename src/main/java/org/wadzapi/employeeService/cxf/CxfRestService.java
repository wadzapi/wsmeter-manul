package org.wadzapi.employeeService.cxf;

import javax.jws.WebService;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 */
@Path("/")
@WebService(name= "employeeService", targetNamespace="http://wadzapi.org/cxf-rest/example")
public interface CxfRestService 
{
	
	@GET
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	@Path("/getemployeedetail")
	Response getEmployeeDetail(@QueryParam("employeeId") String employeeId);
	
}

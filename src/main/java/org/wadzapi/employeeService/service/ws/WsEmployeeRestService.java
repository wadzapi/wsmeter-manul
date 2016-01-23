package org.wadzapi.employeeService.service.ws;

import javax.jws.WebService;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Интерфейс веб-сервиса информации о работниках
 */
@Path("/")
@WebService(name= "employeeService", targetNamespace="http://wadzapi.org/cxf-rest/example")
public interface WsEmployeeRestService
{

	/**
	 * Метод получения информации о работнике по идентификатору
	 *
	 * @param employeeId идентификатор сущности
	 * @return ответ с информацией о работнике
	 */
	@GET
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	@Path("/getemployeedetail")
	Response getEmployeeDetail(@QueryParam("employeeId") String employeeId);
	
}

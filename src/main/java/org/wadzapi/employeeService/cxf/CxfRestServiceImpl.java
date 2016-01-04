package org.wadzapi.employeeService.cxf;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.wadzapi.employeeService.EmployeeInfoProvider;

import javax.ws.rs.core.Response;

@Component
public class CxfRestServiceImpl implements CxfRestService {

	private static final Logger LOGGER = LoggerFactory.getLogger(CxfRestServiceImpl.class);
	
	@Autowired
	private EmployeeInfoProvider employeeInfoProvider;

	@Override
	public Response getEmployeeDetail(String employeeId) 
	{
		final String logMsg = "{} получения инофрмации о пользователе с id: {}" ;
		if(employeeId == null)
		{
			LOGGER.warn(logMsg, "Оишбка запроса", employeeId);
			return Response.status(Response.Status.BAD_REQUEST).build();
		}
		try {
			long empId = Long.parseLong(employeeId);
			return Response.ok(employeeInfoProvider.getEmployeeById((empId))).build();

		} catch (RuntimeException e) {
			LOGGER.error(logMsg, "Ошибка разбора запроса", employeeId);
			LOGGER.debug("Клиенту будет отправлена загрушка ответа!!!!");
			return Response.ok(employeeInfoProvider.getEmployeeDetailsFake(employeeId)).build();

		} catch (Exception e) {
			LOGGER.error(logMsg, "Ошибка разбора запроса", employeeId);
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();

		}

	}
}

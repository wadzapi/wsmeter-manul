package org.wadzapi.employeeService.cxf;

import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;
import  org.wadzapi.employeeService.dao.EmployeeDao;

@Component
public class CxfRestServiceImpl implements CxfRestService {

	private static final Logger LOGGER = LoggerFactory.getLogger(CxfRestServiceImpl.class);
	
	@Autowired
	private EmployeeDao employeeDao;

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
			return Response.ok(employeeDao.getPersistedEmployee(empId)).build();

		} catch (RuntimeException e) {
			LOGGER.error(logMsg, "Ошибка разбора запроса", employeeId);
			LOGGER.debug("Клиенту будет отправлена загрушка ответа!!!!");
			return Response.ok(employeeDao.getEmployeeDetailsFake(employeeId)).build();

		} catch (Exception e) {
			LOGGER.error(logMsg, "Ошибка разбора запроса", employeeId);
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();

		}

	}
}

package org.wadzapi.employeeService.cxf;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.wadzapi.employeeService.processor.DbEmployeeHandler;

import javax.ws.rs.core.Response;

/**
 * Реализация веб-сервиса информации о работниках
 */
@Component
public class CxfRestServiceImpl implements CxfRestService {

	/**
	 * Логгер
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(CxfRestServiceImpl.class);

	/**
	 * Класс-обработчик сущности "Работник"
	 */
	@Autowired
	private DbEmployeeHandler dbEmployeeHandler;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Response getEmployeeDetail(String employeeId) 
	{
		final String logMsg = "{} получения инофрмации о пользователе с id: {}" ;
		if(employeeId == null) {
			LOGGER.warn(logMsg, "Оишбка запроса", "null");
			return Response.status(Response.Status.BAD_REQUEST).build();
		}
		try {
			long empId = Long.parseLong(employeeId);
			return Response.ok(dbEmployeeHandler.getEmployeeById((empId))).build();
		} catch (Exception e) {
			LOGGER.error(logMsg, "Ошибка разбора запроса", employeeId);
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		}
	}
}

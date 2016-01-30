package org.wadzapi.employeeService.service.processor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.wadzapi.employeeService.converter.EmployeeConverter;
import org.wadzapi.employeeService.persist.dao.EmployeeJpaDao;
import org.wadzapi.employeeService.persist.orm.EmployeeOrm;
import org.wadzapi.employeeService.service.model.Employee;

/**
 * Контроллер уровня БД для работы с информацией о работнике из БД
 */
@Controller
public class DbEmployeeHandler implements EmployeeHandler {

    /**
     * Логгер
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(DbEmployeeHandler.class);

    /**
     * DAO для работы с сущностью работника
     */
    @Autowired
    private EmployeeJpaDao employeeDao;

    @Autowired
    private EmployeeConverter employeeConverter;

    /**
     * {@inheritDoc}
     */
    @Override
    public Employee getEmployeeById(long employeeId) {
        final String logMsg = "{} создания ответа из БД для employeeId: {}";
        LOGGER.debug(logMsg, "Начало", employeeId);
        EmployeeOrm employeeOrm = employeeDao.findOne(employeeId);
        Employee employee = employeeConverter.convertFromOrm(employeeOrm);
        LOGGER.debug(logMsg, "Конец", employeeId);
        return employee;
    }
}
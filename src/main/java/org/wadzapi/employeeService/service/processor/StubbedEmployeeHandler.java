package org.wadzapi.employeeService.service.processor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.wadzapi.employeeService.persist.dao.Dao;
import org.wadzapi.employeeService.persist.orm.EmployeeOrm;
import org.wadzapi.employeeService.service.model.Employee;

import java.util.Collections;

/**
 * Моковый контроллер уровня БД для работы с информацией о работнике из БД
 * Передает постоянный набор информации о работнике со статическим набором полей
 */
@Controller
public class StubbedEmployeeHandler implements EmployeeHandler {
    /**
     * Логгер
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(StubbedEmployeeHandler.class);

    /**
     * DAO для работы с сущностью работника
     */
    @Autowired
    private Dao<EmployeeOrm> employeeDao;

    /**
     * {@inheritDoc}
     */
    @Override
    public Employee getEmployeeById(long employeeId) {
        final String logMsg = "{} создания ответа-заглушки для employeeId: {}";
        LOGGER.debug(logMsg, "Начало", employeeId);
        Employee emp = new Employee();
        emp.setEmployeeId(String.valueOf(employeeId));
        emp.setHireDate("01-02-2001");
        emp.setDepartments(Collections.singletonList("Sales"));
        emp.setEmployeeId("675436");
        emp.setFirstName("John");
        emp.setLastName("Smith");
        LOGGER.debug(logMsg, "Конец", employeeId);
        return emp;
    }
}
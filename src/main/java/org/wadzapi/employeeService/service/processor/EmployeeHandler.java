package org.wadzapi.employeeService.service.processor;

import org.wadzapi.employeeService.service.model.Employee;

/**
 * Интерфейс для работы с сущностью "Работник"
 */
public interface EmployeeHandler {


    /**
     * Метод получения информации о работнике по id
     *
     * @param employeeId идентификатор работника
     * @return информаци о работнике по id
     */
    Employee getEmployeeById(long employeeId);

}

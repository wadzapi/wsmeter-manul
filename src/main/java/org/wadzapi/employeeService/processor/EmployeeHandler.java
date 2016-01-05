package org.wadzapi.employeeService.processor;

import org.wadzapi.employeeService.model.Employee;

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

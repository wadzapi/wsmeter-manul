package org.wadzapi.employeeService.converter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.wadzapi.employeeService.model.Employee;
import org.wadzapi.employeeService.persist.orm.DepartmentOrm;
import org.wadzapi.employeeService.persist.orm.EmployeeOrm;

import java.sql.Date;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

/**
 * Конвертер сущности "Работник"
 */
@Component
public class EmployeeConverter {
    //TODO Отказаться от конвертации сущностей? Перейти на работу через orm-сущность?!
    /**
     * Логгер
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeConverter.class);

    /**
     * Тайм-зона для форматтера дат
     */
    private static final ZoneId DATE_TIME_ZONEID = ZoneId.of("Z");

    /**
     * Форматтер даты
     */
    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT)
            .withLocale(Locale.US).withZone(DATE_TIME_ZONEID);

    /**
     * Метод конвертации из orm в сущность модели
     *
     * @param employeeOrm orm работник
     * @return сущность работник
     */
    public Employee convertFromOrm(EmployeeOrm employeeOrm) {
        final String logMsg = "{} конвертации из orm в сущность \"Работник\"";
        LOGGER.debug(logMsg, "Начало");
        Employee employee = new Employee();
        employee.setEmployeeId(String.valueOf(employeeOrm.getId()));
        employee.setDateOfJoining(DATE_TIME_FORMATTER.format(employeeOrm.getHireDate().toInstant()));
        employee.setDepartment(employeeOrm.getDepartment().getName());
        employee.setEmail(employeeOrm.getEmail());
        employee.setFirstName(employeeOrm.getFirstName());
        employee.setLastName(employeeOrm.getLastName());
        LOGGER.debug(logMsg, "Конец");
        return employee;
    }

    /**
     * Метод конвертации из сущности модели в orm
     *
     * @param employee сущность модели
     * @return orm работник
     */
    public EmployeeOrm convertToOrm(Employee employee) {
        final String logMsg = "{} конвертации из сущности \"Работник\" в orm";
        LOGGER.debug(logMsg, "Начало");
        EmployeeOrm employeeOrm = new EmployeeOrm();
        employeeOrm.setId(Long.valueOf(employee.getEmployeeId()));
        LocalDateTime localDateTime = LocalDateTime.parse(employee.getDateOfJoining(), DATE_TIME_FORMATTER);
        employeeOrm.setHireDate(Date.from(localDateTime.toInstant(ZoneOffset.UTC)));
        DepartmentOrm departmentOrm = new DepartmentOrm();
        departmentOrm.setName(employee.getDepartment());
        employeeOrm.setDepartment(departmentOrm);
        employeeOrm.setEmail(employee.getEmail());
        employeeOrm.setFirstName(employee.getFirstName());
        employeeOrm.setLastName(employee.getLastName());
        LOGGER.debug(logMsg, "Конец");
        return null;
    }
}

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
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

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
        employee.setFirstName(employeeOrm.getFirstName());
        employee.setLastName(employeeOrm.getLastName());
        employee.setBirthDate(DATE_TIME_FORMATTER.format(employeeOrm.getBirthDate().toInstant()));
        employee.setHireDate(DATE_TIME_FORMATTER.format(employeeOrm.getHireDate().toInstant()));
        employee.setLeaveDate(DATE_TIME_FORMATTER.format(employeeOrm.getLeaveDate().toInstant()));
        employee.setDepartments(employeeOrm.getDepartmentList().stream().map(employeeOrmItem -> employeeOrmItem.getName()).collect(Collectors.toList()));
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
        EmployeeOrm.EmployeeOrmBuilder employeeOrmBuilder = new EmployeeOrm.EmployeeOrmBuilder();
        DepartmentOrm.DepartmentOrmBuilder departmentOrmBuilder = new DepartmentOrm.DepartmentOrmBuilder();
        List<String> departmentNameList = employee.getDepartments();
        List<DepartmentOrm> departmentOrmList = new ArrayList<>(departmentNameList.size());
        for (String deparmentName : departmentNameList) {
            departmentOrmList.add(departmentOrmBuilder.setName(deparmentName).build());
        }
        employeeOrmBuilder.setId(Long.valueOf(employee.getEmployeeId()))
                .setBirthDate(Date.from(LocalDateTime.parse(employee.getBirthDate(), DATE_TIME_FORMATTER).toInstant(ZoneOffset.UTC)))
                .setHireDate(Date.from(LocalDateTime.parse(employee.getHireDate(), DATE_TIME_FORMATTER).toInstant(ZoneOffset.UTC)))
                .setLeaveDate(Date.from(LocalDateTime.parse(employee.getLeaveDate(), DATE_TIME_FORMATTER).toInstant(ZoneOffset.UTC)))
                .setDepartmentList(departmentOrmList)
                .setFirstName(employee.getFirstName())
                .setLastName(employee.getLastName());
        LOGGER.debug(logMsg, "Конец");
        return employeeOrmBuilder.build();
    }
}

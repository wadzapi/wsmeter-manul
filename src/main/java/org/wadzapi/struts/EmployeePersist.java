package org.wadzapi.struts;

import com.opensymphony.xwork2.ActionSupport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.wadzapi.employeeService.persist.dao.DepartmentJpaDao;
import org.wadzapi.employeeService.persist.dao.EmployeeJpaDao;
import org.wadzapi.employeeService.persist.orm.DepartmentOrm;
import org.wadzapi.employeeService.persist.orm.EmployeeOrm;

import java.util.List;

/**
 * Класс-действие для сохранения информации о работнике
 */
@Component
public class EmployeePersist extends ActionSupport {

    /**
     * Логгер
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeePersist.class);

    /**
     * DAO для работы с сущность "Департамент"
     */
    private DepartmentJpaDao departmentsPersister;

    /**
     * DAO для работы с сущностью "Работник"
     */
    private EmployeeJpaDao employeePersister;

    /**
     * Список департаментов
     */
    private List<DepartmentOrm> departments;

    /**
     * Список работников
     */
    private List<EmployeeOrm> employees;

    /**
     * Конструктор класса
     */
    @Autowired
    public EmployeePersist(DepartmentJpaDao departmentJpaDao, EmployeeJpaDao employeeJpaDao) {
        this.departmentsPersister = departmentJpaDao;
        departments = departmentsPersister.findAll();
        this.employeePersister = employeeJpaDao;
        employees = employeePersister.findAll();
    }

    /**
     * Метод выполнения действия
     *
     * @return результат выполнения действия
     * @throws Exception ошибка при выполнении действий
     */
    public String execute() throws Exception {
        final String logMsg = "{} выполенения действия сохранения состояния сущностей";
        LOGGER.info(logMsg, "Начало");
        for (DepartmentOrm department : departments) {
            departmentsPersister.persist(department);
        }
        for (EmployeeOrm employee : employees) {
            employeePersister.persist(employee);
        }
        LOGGER.info(logMsg, "Конец");
        return SUCCESS;
    }
}
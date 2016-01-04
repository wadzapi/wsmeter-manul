package org.wadzapi.struts;

import com.opensymphony.xwork2.ActionSupport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.wadzapi.employeeService.persist.dao.DepartmentJpaDao;
import org.wadzapi.employeeService.persist.dao.EmployeeJpaDao;
import org.wadzapi.employeeService.persist.orm.DepartmentOrm;
import org.wadzapi.employeeService.persist.orm.EmployeeOrm;

import java.util.List;

@Component
public class DataPersister extends ActionSupport {

    private static final Logger LOGGER = LoggerFactory.getLogger(DataPersister.class);

    private DepartmentJpaDao departmentsPersister;

    private EmployeeJpaDao employeePersister;

    private List<DepartmentOrm> departments;

    private List<EmployeeOrm> employees;


    public DataPersister() {
        departmentsPersister = new DepartmentJpaDao();
        departments = departmentsPersister.findAll();
        employeePersister = new EmployeeJpaDao();
        employees = employeePersister.findAll();
    }


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
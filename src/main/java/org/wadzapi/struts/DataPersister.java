package org.wadzapi.struts;

import com.opensymphony.xwork2.ActionSupport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.wadzapi.persister.DepartmentJpaPersiter;
import org.wadzapi.persister.EmployeeJpaPersiter;
import org.wadzapi.persister.Persister;
import org.wadzapi.persister.orm.DepartmentOrm;
import org.wadzapi.persister.orm.EmployeeOrm;

import java.util.List;

@Component
public class DataPersister extends ActionSupport {

    private static final Logger LOGGER = LoggerFactory.getLogger(DataPersister.class);

    private Persister departmentsPersister;

    private Persister employeePersister = new EmployeeJpaPersiter();

    private List<DepartmentOrm> departments;

    private List<EmployeeOrm> employees;


    public DataPersister() {
        departmentsPersister = new DepartmentJpaPersiter();
        departments = new DepartmentJpaPersiter().load();
        employeePersister = new EmployeeJpaPersiter();
        employees = employeePersister.load();
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
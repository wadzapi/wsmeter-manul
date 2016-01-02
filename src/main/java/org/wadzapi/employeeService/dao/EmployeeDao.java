package org.wadzapi.employeeService.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.wadzapi.employeeService.model.Employee;
import org.wadzapi.persister.Persister;
import org.wadzapi.persister.orm.EmployeeOrm;

import java.util.List;

@Component
public class EmployeeDao 
{

	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeDao.class);

	@Autowired
	private Persister<EmployeeOrm> employeePersister;

	@Autowired
	public EmployeeDao(Persister<EmployeeOrm> employeePersister) {
		this.employeePersister = employeePersister;
	}

	public Employee getEmployeeDetailsFake(String employeeId)
	{
		final String logMsg = "{} создания ответа-заглушки для employeeId: {}";
		LOGGER.debug("Начало", employeeId);
		Employee emp = new Employee();
		emp.setEmployeeId(employeeId);
		emp.setDateOfJoining("01-02-2001");
		emp.setDepartment("Sales");
		emp.setEmail("test@example.com");
		emp.setEmployeeId("675436");
		emp.setFirstName("John");
		emp.setLastName("Smith");
		LOGGER.debug("Конец", employeeId);
		return emp;
	}


	public List<EmployeeOrm> getPersistedEmployees() {
		return employeePersister.load();
	}

	public List<EmployeeOrm> getPersistedEmployee(long empId) {
		return employeePersister.load();
	}
}
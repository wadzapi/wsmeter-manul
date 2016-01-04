package org.wadzapi.employeeService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.wadzapi.employeeService.model.Employee;
import org.wadzapi.employeeService.persist.dao.Dao;
import org.wadzapi.employeeService.persist.orm.EmployeeOrm;

import java.util.List;

@Component
public class EmployeeInfoProvider
{

	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeInfoProvider.class);

	@Autowired
	private Dao<EmployeeOrm> employeeDao;

	@Autowired
	public EmployeeInfoProvider(Dao<EmployeeOrm> employeeDao) {
		this.employeeDao = employeeDao;
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
		return employeeDao.findAll();
	}

	public EmployeeOrm getEmployeeById(long empId) {
		return employeeDao.findOne(empId);
	}
}